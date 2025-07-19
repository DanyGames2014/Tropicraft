package net.danygames2014.tropicraft.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class TropiEntityRenderer extends LivingEntityRenderer {
    public String texture;

    public TropiEntityRenderer(EntityModel model, float shadowRadius, String texture) {
        super(model, shadowRadius);
        this.texture = texture;
    }

    public void render(LivingEntity entity, double x, double y, double z, float g, float delta) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);

        this.model.handSwingProgress = this.getHandSwingProgress(entity, delta);
        if (this.decorationModel != null) {
            this.decorationModel.handSwingProgress = this.model.handSwingProgress;
        }

        this.model.riding = entity.hasVehicle();
        if (this.decorationModel != null) {
            this.decorationModel.riding = this.model.riding;
        }

        try {
            // Calculate Rotation
            float bodyYaw = entity.lastBodyYaw + (entity.bodyYaw - entity.lastBodyYaw) * delta;
            float headYaw = entity.prevYaw + (entity.yaw - entity.prevYaw) * delta;
            float headPitch = entity.prevPitch + (entity.pitch - entity.prevPitch) * delta;

            // "Set Rendering Position in World"
            GL11.glTranslated(x,y,z);

            float animationProgress = this.getHeadBob(entity, delta);
            this.applyHandSwingRotation(entity, animationProgress, bodyYaw, delta);
            float scale = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);
            this.applyScale(entity, delta); // preRender

            GL11.glTranslatef(0.0F, -0.06F, 0.0F);

//            GL11.glTranslatef(0.0F, -24.0F * scale - 0.0078125F, 0.0F);
//            GL11.glTranslatef(0.0F, -2.0F, 0.0F);

            float nextLimbDistance = entity.lastWalkAnimationSpeed + (entity.walkAnimationSpeed - entity.lastWalkAnimationSpeed) * delta;
            float nextLimbAngle = entity.walkAnimationProgress - entity.walkAnimationSpeed * (1.0F - delta);
            if (nextLimbDistance > 1.0F) {
                nextLimbDistance = 1.0F;
            }

            this.bindTexture(this.texture);

            GL11.glEnable(GL11.GL_ALPHA_TEST);
            this.model.animateModel(entity, nextLimbAngle, nextLimbDistance, delta);
            this.model.setAngles(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);
            this.model.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);

//            for(int layer = 0; layer < 4; ++layer) {
//                if (this.method_825(entity, layer, delta)) { // renderOuterLayer
//                    this.field_910.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);
//                    GL11.glDisable(GL11.GL_BLEND);
//                    GL11.glEnable(GL11.GL_ALPHA_TEST);
//                }
//            }
//
//            this.method_827(entity, delta); // renderPlayerEffects
            float brightness = entity.getBrightnessAtEyes(delta);
            int color = this.getOverlayColor(entity, brightness, delta); // getColor

            // Hurt Animation Rendering
            if ((color >> 24 & 255) > 0 || entity.hurtTime > 0 || entity.deathTime > 0) {
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_ALPHA_TEST);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (entity.hurtTime > 0 || entity.deathTime > 0) {
                    GL11.glColor4f(brightness, 0.0F, 0.0F, 0.4F);
                    this.model.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);

//                    for(int layer = 0; layer < 4; ++layer) {
//                        if (this.method_819(entity, layer, delta)) { // renderLayer
//                            GL11.glColor4f(brightness, 0.0F, 0.0F, 0.4F);
//                            this.field_910.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);
//                        }
//                    }
                }

                if ((color >> 24 & 255) > 0) {
                    float red = (float)(color >> 16 & 255) / 255.0F;
                    float green = (float)(color >> 8 & 255) / 255.0F;
                    float blue = (float)(color & 255) / 255.0F;
                    float alpha = (float)(color >> 24 & 255) / 255.0F;
                    GL11.glColor4f(red, green, blue, alpha);
                    this.model.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);

//                    for(int layer = 0; layer < 4; ++layer) {
//                        if (this.method_819(entity, layer, delta)) { // renderLayer
//                            GL11.glColor4f(red, green, blue, alpha);
//                            this.field_910.render(nextLimbAngle, nextLimbDistance, animationProgress, headYaw - bodyYaw, headPitch, scale);
//                        }
//                    }
                }

                GL11.glDepthFunc(515);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
            }

            GL11.glDisable(32826);
        } catch (Exception e) {
            e.printStackTrace();
        }

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
        this.renderNameTag(entity, x, y, z); // Render Entity Name
    }
}
