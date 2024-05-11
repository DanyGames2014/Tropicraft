package net.danygames2014.tropicraft.util;

import net.minecraft.client.model.ModelPart;
import net.minecraft.util.math.MathHelper;

public class TropiModelPart extends ModelPart {

    public float defaultPitch;
    public float defaultYaw;
    public float defaultRoll;
    public float defaultPivotX;
    public float defaultPivotZ;

    public TropiModelPart(int u, int v, boolean mirror) {
        super(u, v);
        this.defaultPitch = this.pitch = 0.0F;
        this.defaultYaw = this.yaw = 0.0F;
        this.defaultRoll = this.roll = 0.0F;
        this.mirror = mirror;
    }

    public TropiModelPart(int u, int v) {
        this(u, v, false);
    }

    public void addCube(float x, float y, float z, int sizeX, int sizeY, int sizeZ, float pivotX, float pivotY, float pivotZ) {
        y = -y;
        pivotY = -pivotY;

        x -= pivotX;
        y -= pivotY;
        z -= pivotZ;

        y -= sizeY - 1;

        this.addCuboid(x, y, z, sizeX, sizeY, sizeZ);
        this.setPivot(pivotX, pivotY, pivotZ);

        this.defaultPivotX = pivotX;
        this.defaultPivotZ = pivotZ;
    }

    public void angleHead(float headPitch, float headYaw) {
        this.pitch = headPitch * 0.01745328627F;
        this.yaw = headYaw * 0.01745328627F;
    }

    public void angleLeg(float limbAngle, float limbDistance, boolean invertMovement) {
        if (invertMovement) {
            this.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
            return;
        }
        this.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }

    public void angleLeg(float limbAngle, float limbDistance) {
        this.angleLeg(limbAngle, limbDistance, false);
    }
}
