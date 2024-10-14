package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.EIHEntity;
import net.danygames2014.tropicraft.entity.model.EIHModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class EIHRenderer extends TropiEntityRenderer {
    public EIHRenderer() {
        super(new EIHModel(), 0.5F, "/assets/tropicraft/stationapi/textures/entity/eih/normal.png");
    }

    @Override
    protected void applyScale(LivingEntity entity, float f) {
        switch (((EIHEntity) entity).getMood()) {
            case 1 -> this.texture = "/assets/tropicraft/stationapi/textures/entity/eih/aware.png";
            case 2 -> this.texture = "/assets/tropicraft/stationapi/textures/entity/eih/angry.png";
            default -> this.texture = "/assets/tropicraft/stationapi/textures/entity/eih/normal.png";
        }
        GL11.glScalef(2.0f, 1.75f, 2.0f);
    }
}
