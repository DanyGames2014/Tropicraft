package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.model.IguanaModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class IguanaRenderer extends TropiEntityRenderer {

    public IguanaRenderer() {
        super(new IguanaModel(), 0.5F, "/assets/tropicraft/stationapi/textures/entity/iguana.png");
    }

//    @Override
//    public void render(LivingEntity entity, double x, double y, double z, float g, float h) {
//        GL11.glPushMatrix();
//        GL11.glTranslatef((float)x, (float)y - 0.2f, (float)z);
//        GL11.glRotatef(180.0f - g, 0.0f, 1.0f, 0.0f);
//        float f4 = 0.75f;
//        GL11.glScalef(f4, f4, f4);
//        GL11.glScalef(1.0f / f4, 1.0f / f4, 1.0f / f4);
//        this.bindTexture("/assets/tropicraft/stationapi/textures/entity/iguana.png");
//        GL11.glScalef(-1.0f, -1.0f, 1.0f);
//        this.model.render(0.0F,1.0F,0.1F,0.0F,0.0F,0.0625F);
//        GL11.glPopMatrix();
//        super.render(entity, x, y, z, g, h);
//    }
}
