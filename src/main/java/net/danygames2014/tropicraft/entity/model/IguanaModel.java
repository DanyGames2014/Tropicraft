package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class IguanaModel extends EntityModel {
    public TropiModelPart body = new TropiModelPart(0, 16);
    public TropiModelPart frontRightLeg = new TropiModelPart(0, 21, true);
    public TropiModelPart backRightLeg = new TropiModelPart(0, 21, true);
    public TropiModelPart frontLeftLeg = new TropiModelPart(24, 21, true);
    public TropiModelPart backLeftLeg = new TropiModelPart(24, 21, true);
    public TropiModelPart topBase = new TropiModelPart(0, 0);
    public TropiModelPart topMiddle = new TropiModelPart(32, 0);
    public TropiModelPart topPeak = new TropiModelPart(32, 7);
    public TropiModelPart tailFirstSegment = new TropiModelPart(46, 0);
    public TropiModelPart tailMiddleSegment = new TropiModelPart(48, 7);
    public TropiModelPart tailTailSegment = new TropiModelPart(52, 14);
    public TropiModelPart head = new TropiModelPart(36, 23);
    public TropiModelPart headSpikeBottom = new TropiModelPart(32, 7);
    public TropiModelPart headSpikeTop = new TropiModelPart(0, 0);
    public TropiModelPart headUnderpartTop = new TropiModelPart(0, 11);
    public TropiModelPart headUnderpartBottom = new TropiModelPart(0, 4);

    public IguanaModel() {
        this.body.addCube(-2.5F, 1.0F, -6.5F, 5, 3, 13, 0.0F, 0.0F, 0.0F);
        this.frontRightLeg.addCube(2.5F, 0.0F, -5.5F, 2, 3, 3, 3.0F, 2.5F, -4.0F);
        this.backRightLeg.addCube(2.5F, 0.0F, 2.5F, 2, 3, 3, 3.0F, 2.5F, 4.0F);
        this.frontLeftLeg.addCube(-4.5F, 0.0F, -5.5F, 2, 3, 3, -3.0F, 2.5F, -4.0F);
        this.backLeftLeg.addCube(-4.5F, 0.0F, 2.5F, 2, 3, 3, -3.0F, 2.5F, 4.0F);
        this.topBase.addCube(-1.5F, 4.0F, -5.0F, 3, 1, 10, 0.0F, 0.0F, 0.0F);
        this.topMiddle.addCube(-0.5F, 5.0F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F);
        this.topPeak.addCube(-0.5F, 6.0F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F);
        this.tailFirstSegment.addCube(-1.5F, 2.0F, 6.0F, 3, 1, 6, 0.0F, 2.5F, 6.0F);
        this.tailMiddleSegment.addCube(-1.0F, 2.0F, 12.0F, 2, 1, 6, 0.0F, 2.5F, 12.0F);
        this.tailTailSegment.addCube(-0.5F, 2.0F, 18.0F, 1, 1, 5, 0.0F, 2.5F, 18.0F);
        this.head.addCube(-2.5F, 3.0F, -12.0F, 5, 3, 6, 0.0F, 4.0F, -6.0F);
        this.headSpikeBottom.addCube(-0.5F, 6.0F, -11.0F, 1, 1, 4, 0.0F, 4.0F, -6.0F);
        this.headSpikeTop.addCube(-0.5F, 7.0F, -10.0F, 1, 1, 2, 0.0F, 4.0F, -6.0F);
        this.headUnderpartTop.addCube(-1.0F, 2.0F, -10.0F, 2, 1, 4, 0.0F, 4.0F, -6.0F);
        this.headUnderpartBottom.addCube(-0.5F, 1.0F, -9.0F, 1, 1, 3, 0.0F, 4.0F, -6.0F);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.body.render(scale);
        this.frontRightLeg.render(scale);
        this.backRightLeg.render(scale);
        this.frontLeftLeg.render(scale);
        this.backLeftLeg.render(scale);
        this.topBase.render(scale);
        this.topMiddle.render(scale);
        this.topPeak.render(scale);
        this.tailFirstSegment.render(scale);
        this.tailMiddleSegment.render(scale);
        this.tailTailSegment.render(scale);
        this.head.render(scale);
        this.headSpikeBottom.render(scale);
        this.headSpikeTop.render(scale);
        this.headUnderpartTop.render(scale);
        this.headUnderpartBottom.render(scale);
    }

    public float tailAngle1 = 0.0F;
    public float tailAngle2 = 0.0F;
    public float tailAngle3 = 0.0F;

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        this.head.angleHead(headPitch, headYaw);
        this.headSpikeTop.angleHead(headPitch, headYaw);
        this.headSpikeBottom.angleHead(headPitch, headYaw);
        this.headUnderpartTop.angleHead(headPitch, headYaw);
        this.headUnderpartBottom.angleHead(headPitch, headYaw);

        this.frontRightLeg.angleLeg(limbAngle, limbDistance, true);
        this.backRightLeg.angleLeg(limbAngle, limbDistance);
        this.frontLeftLeg.angleLeg(limbAngle, limbDistance);
        this.backLeftLeg.angleLeg(limbAngle, limbDistance, true);

        tailAngle1 += 1.2F;
        tailAngle2 += 1.5F;
        tailAngle3 += 1.7F;

        tailAngle1 = tailAngle1 % 360F;
        tailAngle2 = tailAngle2 % 360F;
        tailAngle3 = tailAngle3 % 360F;

        setTailAngle(tailAngle1, tailAngle2, tailAngle3);
    }

    // tailangle 0 - 360
    public void setTailAngle(float firstSegmentAngle, float secondSegmentAngle, float thirdSegmentAngle) {
        // First Segment
        this.tailFirstSegment.yaw = MathHelper.cos(firstSegmentAngle * 0.01745328627F);

        // Second Segment
        this.tailMiddleSegment.yaw = MathHelper.cos(secondSegmentAngle * 0.01745328627F);
        this.tailMiddleSegment.pivotX = MathHelper.sin(this.tailFirstSegment.yaw) * 6F;
        this.tailMiddleSegment.pivotZ = (MathHelper.cos(this.tailFirstSegment.yaw) * 6F) + 6F;

        // Third Segment
        this.tailTailSegment.yaw = MathHelper.cos(thirdSegmentAngle * 0.01745328627F);
        this.tailTailSegment.pivotX = this.tailMiddleSegment.pivotX + (MathHelper.sin(this.tailMiddleSegment.yaw) * 6F);
        this.tailTailSegment.pivotZ = this.tailMiddleSegment.pivotZ + (MathHelper.cos(this.tailMiddleSegment.yaw) * 6F);

    }
}
