package net.danygames2014.tropicraft.util;

import net.minecraft.client.model.ModelPart;

public class TropiModelPart extends ModelPart {
    public TropiModelPart(int u, int v) {
        super(u, v);
        this.pitch = 0.0F;
        this.yaw = 0.0F;
        this.roll = 0.0F;
        this.mirror = false;
    }
}
