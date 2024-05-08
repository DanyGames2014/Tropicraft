package net.danygames2014.tropicraft.util;

import net.minecraft.client.model.ModelPart;

public class TropiModelPart extends ModelPart {
    public TropiModelPart(int u, int v, boolean mirror) {
        super(u, v);
        this.pitch = 0.0F;
        this.yaw = 0.0F;
        this.roll = 0.0F;
        this.mirror = mirror;
    }

    public TropiModelPart(int u, int v) {
        this(u, v, false);
    }

    public void addCube(float x, float y, float z, int sizeX, int sizeY, int sizeZ, float pivotX, float pivotY, float pivotZ) {
        x -= pivotX;
        y -= pivotY;
        z -= pivotZ;
        this.addCuboid(x, y, z, sizeX, sizeY, sizeZ);
        this.setPivot(pivotX, pivotY, pivotZ);
    }
}
