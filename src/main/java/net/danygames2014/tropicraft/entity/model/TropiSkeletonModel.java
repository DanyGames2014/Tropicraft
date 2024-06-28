package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.render.entity.model.SkeletonEntityModel;

public class TropiSkeletonModel extends SkeletonEntityModel {
    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.head.render(scale);
        this.body.render(scale);
        this.rightArm.render(scale);
        this.leftArm.render(scale);
        this.rightLeg.render(scale);
        this.leftLeg.render(scale);
//        this.hat.render(scale);
    }
}
