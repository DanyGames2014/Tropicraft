package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class TreeFrogModel extends EntityModel {
    public TropiModelPart body = new TropiModelPart(28,8);
    public TropiModelPart frontRightLeg = new TropiModelPart(12,14);
    public TropiModelPart frontLeftLeg = new TropiModelPart(12,19);
    public TropiModelPart rearRightLeg = new TropiModelPart(0,16);
    public TropiModelPart rearLeftLeg = new TropiModelPart(0,8);
    public TropiModelPart rightEye = new TropiModelPart(0,0,true);
    public TropiModelPart leftEye = new TropiModelPart(0,4, true);

    public TreeFrogModel() {
        body.addCube(-2,4,1,4,9,4,0,3,4);
        body.pitch = (float) (Math.PI / 2F);
        frontRightLeg.addCube(0,0,-6,4,1,4,1,1,-3);
        frontLeftLeg.addCube(-4,0,-6,4,1,4,-1,1,-3);
        rearRightLeg.addCube(2,0,1,3,5,3,2,4,2);
        rearLeftLeg.addCube(-5,0,1,3,5,3,-2,4,2);
        rightEye.addCube(1,4,-3,2,2,2,2,4,-2);
        leftEye.addCube(-3,4,-3,2,2,2,-2,4,-2);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        body.render(scale);
        frontRightLeg.render(scale);
        frontLeftLeg.render(scale);
        rearRightLeg.render(scale);
        rearLeftLeg.render(scale);
        rightEye.render(scale);
        leftEye.render(scale);
    }

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        frontRightLeg.pitch = MathHelper.cos(limbAngle * 0.6662f) * 1.4f * limbDistance;
        frontLeftLeg.pitch = MathHelper.cos(limbAngle * 0.6662f) * 1.4f * limbDistance;
        rearRightLeg.pitch = MathHelper.cos(limbAngle * 0.6662f + 3.141593f) * 1.4f * limbDistance;
        rearLeftLeg.pitch = MathHelper.cos(limbAngle * 0.6662f + 3.141593f) * 1.4f * limbDistance;
    }
}
