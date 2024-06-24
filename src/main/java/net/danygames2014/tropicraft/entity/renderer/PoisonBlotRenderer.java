package net.danygames2014.tropicraft.entity.renderer;

import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class PoisonBlotRenderer extends EntityRenderer {

    @Override
    public void render(Entity blotEntity, double d, double e, double f, float g, float h) {
        if (blotEntity.prevYaw != 0.0F || blotEntity.prevPitch != 0.0F) {
            this.bindTexture("/assets/tropicraft/stationapi/textures/entity/frog/poison_blot.png");
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d, (float)e, (float)f);
            GL11.glRotatef(blotEntity.prevYaw + (blotEntity.yaw - blotEntity.prevYaw) * h - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(blotEntity.prevPitch + (blotEntity.pitch - blotEntity.prevPitch) * h, 0.0F, 0.0F, 1.0F);

            byte var11 = 0;
            float var12 = 0.0F;
            float var13 = 0.5F;
            float var14 = (float)(var11 * 10) / 32.0F;
            float var15 = (float)(5 + var11 * 10) / 32.0F;
            float var16 = 0.0F;
            float var17 = 0.15625F;
            float var18 = (float)(5 + var11 * 10) / 32.0F;
            float var19 = (float)(10 + var11 * 10) / 32.0F;
            float var20 = 0.05625F;

            Tessellator tessellator = Tessellator.INSTANCE;

            GL11.glEnable(32826);
            GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(var20, var20, var20);
            GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
            GL11.glNormal3f(var20, 0.0F, 0.0F);
            tessellator.startQuads();
            tessellator.vertex(-7.0, -2.0, -2.0, var16, var18);
            tessellator.vertex(-7.0, -2.0, 2.0, var17, var18);
            tessellator.vertex(-7.0, 2.0, 2.0, var17, var19);
            tessellator.vertex(-7.0, 2.0, -2.0, var16, var19);
            tessellator.draw();
            GL11.glNormal3f(-var20, 0.0F, 0.0F);
            tessellator.startQuads();
            tessellator.vertex(-7.0, 2.0, -2.0, var16, var18);
            tessellator.vertex(-7.0, 2.0, 2.0, var17, var18);
            tessellator.vertex(-7.0, -2.0, 2.0, var17, var19);
            tessellator.vertex(-7.0, -2.0, -2.0, var16, var19);
            tessellator.draw();

            for(int var23 = 0; var23 < 4; ++var23) {
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glNormal3f(0.0F, 0.0F, var20);
                tessellator.startQuads();
                tessellator.vertex(-8.0, -2.0, 0.0, var12, var14);
                tessellator.vertex(8.0, -2.0, 0.0, var13, var14);
                tessellator.vertex(8.0, 2.0, 0.0, var13, var15);
                tessellator.vertex(-8.0, 2.0, 0.0, var12, var15);
                tessellator.draw();
            }

            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }
}
