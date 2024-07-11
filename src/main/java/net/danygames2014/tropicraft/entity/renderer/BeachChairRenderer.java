package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.BeachChairEntity;
import net.danygames2014.tropicraft.entity.model.BeachChairModel;
import net.danygames2014.tropicraft.util.ColorHelper;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;

public class BeachChairRenderer extends EntityRenderer {
    BeachChairModel model;

    float red = 0.0F;
    float green = 0.4F;
    float blue = 0.6F;
    FloatBuffer color;

    public BeachChairRenderer() {
        shadowRadius = 0.5F;
        model = new BeachChairModel();
    }

    int chairColor = 0;
    float chairBrightness = 1.0F;

    @Override
    public void render(Entity entity, double x, double y, double z, float f, float g) {
        // Retrieve chair color
        chairColor = ((BeachChairEntity) entity).getColor();
        chairBrightness = entity.getBrightnessAtEyes(0F);

        red = ColorHelper.getRed(chairColor) * chairBrightness;
        green = ColorHelper.getGreen(chairColor) * chairBrightness;
        blue = ColorHelper.getBlue(chairColor) * chairBrightness;

        // Position the chair in world
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) (y - 0.4375F), (float) z);
        GL11.glRotatef(f + (180 - f) * 2, 0.0F, 1.0F, 0.0F);

        // Render the base texture of the chair (bamboo parts)
        this.bindTexture("/assets/tropicraft/stationapi/textures/entity/beach_chair/base.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        model.render(0.0F, 1.0F, 0.1F, 0.0F, 0.0F, 0.0625F);

        // Render the cloth part of the chair that is gonna get colored
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_BLEND);
        color = BufferUtils.createFloatBuffer(4).put(new float[]{red, green, blue, 1.0F});
        color.position(0);
        GL11.glTexEnv(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_COLOR, color);
        this.bindTexture("/assets/tropicraft/stationapi/textures/entity/beach_chair/color.png");
        model.render(0.0F, 1.0F, 0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }


}
