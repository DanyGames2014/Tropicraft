package net.danygames2014.tropicraft.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(EnvType.CLIENT)
public class BeachChairModel extends EntityModel {
    public TropiModelPart seat = new TropiModelPart(0,0);
    public TropiModelPart back = new TropiModelPart(0,0);
    public TropiModelPart backRightLeg = new TropiModelPart(0,0);
    public TropiModelPart backLeftLeg = new TropiModelPart(0,0);
    public TropiModelPart frontRightLeg = new TropiModelPart(0,0);
    public TropiModelPart frontLeftLeg = new TropiModelPart(0,0);
    public TropiModelPart leftArm = new TropiModelPart(0,29);
    public TropiModelPart rightArm = new TropiModelPart(0,29);

    public BeachChairModel() {
        seat.addCube(-8, 4, -8, 16, 1, 16, -7, 4, -7);
        back.addCube(-8, 5, 7, 16, 1, 16, 0, 5, 8);
        back.pitch = 1.17809725F; // 67.5°
        backRightLeg.addCube(8.0F, 0.5F, 9.3F, 1, 10, 1, 9.0F, 0.5F, 10.3F);
        backRightLeg.pitch = 0.453785606F; // 26°
        backLeftLeg.addCube(-9, 0.5F, 9.3F, 1, 10, 1, -8.0F, 0.5F, 10.3F);
        backLeftLeg.pitch = 0.453785606F; // 26°
        frontLeftLeg.addCube(-9.0F, 0.0F, -5.5F, 1, 10, 1, -8.0F, 0.0F, -4.5F);
        frontLeftLeg.pitch = -0.453785606F; // -26°
        frontRightLeg.addCube(8.0F, 0.0F, -5.5F, 1, 10, 1, 9.0F, 0.0F, -4.5F);
        frontRightLeg.pitch = -0.453785606F; // -26°
        leftArm.addCube(-9.5F, 8.7F, 8.5F, 14, 1, 2, -8.5F, 8.7F, 9.5F);
        leftArm.yaw = 1.57079633F; // 90°
        rightArm.addCube(7.5F, 8.7F, 8.5F, 14, 1, 2, 8.5F, 8.7F, 9.5F);
        rightArm.yaw = 1.57079633F; // 90°
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        seat.render(scale);
        back.render(scale);
        backRightLeg.render(scale);
        backLeftLeg.render(scale);
        frontRightLeg.render(scale);
        frontLeftLeg.render(scale);
        leftArm.render(scale);
        rightArm.render(scale);
    }
}
