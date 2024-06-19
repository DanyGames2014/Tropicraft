package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.FrogType;
import net.danygames2014.tropicraft.entity.model.TreeFrogModel;

public class FrogRenderer extends TropiEntityRenderer{

    public FrogRenderer(FrogType type) {
        super(new TreeFrogModel(), 0.5F, type.texture);
    }
}
