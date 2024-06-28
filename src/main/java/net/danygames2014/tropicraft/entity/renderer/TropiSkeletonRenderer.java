package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.model.TropiSkeletonModel;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;

public class TropiSkeletonRenderer extends SkeletonEntityRenderer {
    public TropiSkeletonRenderer() {
        super(new TropiSkeletonModel(), 0.5F);
    }
}
