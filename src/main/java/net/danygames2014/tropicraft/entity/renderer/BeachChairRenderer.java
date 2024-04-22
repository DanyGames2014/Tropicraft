package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.model.BeachChairModel;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class BeachChairRenderer extends EntityRenderer {

    public EntityModel beachChairModel;

    public BeachChairRenderer() {
        this.field_2678 = 0.5F; // shadowRadius
        this.beachChairModel = new BeachChairModel();
    }

    @Override
    public void render(Entity entity, double x, double y, double z, float g, float h) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y - 0.2f, (float)z);
        GL11.glRotatef(180.0f - g, 0.0f, 1.0f, 0.0f);
        float f4 = 0.75f;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0f / f4, 1.0f / f4, 1.0f / f4);
        this.bindTexture("/assets/tropicraft/stationapi/textures/entity/beach_chair/beach_chair_red.png");
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.beachChairModel.render(0.0F,1.0F,0.1F,0.0F,0.0F,0.0625F);
        GL11.glPopMatrix();
    }
}
