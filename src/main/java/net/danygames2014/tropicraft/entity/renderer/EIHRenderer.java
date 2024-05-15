package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.model.EIHModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.opengl.GL11;

public class EIHRenderer extends TropiEntityRenderer{
    public EIHRenderer() {
        super(new EIHModel(), 0.5F, "/assets/tropicraft/stationapi/textures/entity/eih/normal.png");
    }

    @Override
    protected void method_823(LivingEntity arg, float f) {
        GL11.glScalef(2.0f, 1.75f, 2.0f);
    }
}
