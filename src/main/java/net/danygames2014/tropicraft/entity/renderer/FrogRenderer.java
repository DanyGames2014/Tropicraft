package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.FrogType;
import net.danygames2014.tropicraft.entity.model.FrogModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FrogRenderer extends TropiEntityRenderer{

    public FrogRenderer(FrogType type) {
        super(new FrogModel(), 0.5F, type.texture);
    }
}
