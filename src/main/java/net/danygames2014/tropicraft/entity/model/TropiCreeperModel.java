package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.render.entity.model.CreeperEntityModel;

public class TropiCreeperModel extends CreeperEntityModel {
    TropiModelPart hat1;
    TropiModelPart hat2;
    TropiModelPart hat3;

    public TropiCreeperModel() {
        super();
        this.hat1 = new TropiModelPart(24, 0, true);
        this.hat1.addCube(-6.0F, 4.5F, -6.0F, 12, 1, 6, 0.0F, -3.0F, 0.0F);

        this.hat2 = new TropiModelPart(42, 8);
        this.hat2.addCube(-3.0F, 4.5F, -3.0F, 6, 2, 6, 0.0F, -5.0F, 0.0F);

        this.hat3 = new TropiModelPart(24, 0);
        this.hat3.addCube(-6.0F, 4.5F, 0.0F, 12, 1, 6, 0.0F, -3.0F, 0.0F);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.head.render(scale);
        this.body.render(scale);
        this.rightHindLeg.render(scale);
        this.leftHindLeg.render(scale);
        this.rightFrontLeg.render(scale);
        this.leftFrontLeg.render(scale);
        this.hat1.render(scale);
        this.hat2.render(scale);
        this.hat3.render(scale);
    }

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.hat1.pitch = this.hat2.pitch = this.hat3.pitch = this.head.pitch;
        this.hat1.yaw = this.hat2.yaw = this.hat3.yaw = this.head.yaw;
    }
}
