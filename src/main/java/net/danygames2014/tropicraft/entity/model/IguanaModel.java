package net.danygames2014.tropicraft.entity.model;

import net.danygames2014.tropicraft.util.TropiModelPart;
import net.minecraft.client.render.entity.model.EntityModel;

public class IguanaModel extends EntityModel {
    public TropiModelPart body = new TropiModelPart(0, 16);
    public TropiModelPart frontRightLeg = new TropiModelPart(0, 21, true);
    public TropiModelPart backRightLeg = new TropiModelPart(0, 21, true);
    public TropiModelPart frontLeftLeg = new TropiModelPart(24, 21, true);
    public TropiModelPart backLeftLeg = new TropiModelPart(24, 21, true);

    public IguanaModel() {
        this.body.addCube(-2.5F, 1.0F, -6.5F, 5, 3, 13, 0.0F, 0.0F, 0.0F);
//        this.body.addCuboid(-2.5F, 1.0F, -6.5F, 5, 3, 13);
//        this.body.setPivot(0.0F, 0.0F, 0.0F);

//        this.frontRightLeg.addCube(2.5F, 0.0F, -5.5F, 2, 3, 3, 3.0F, 2.5F, -4.0F);

//        this.frontRightLeg.addCuboid(2.5F, 0.0F, -5.5F, 2, 3, 3);
//        this.frontRightLeg.setPivot(3.0F, 2.5F, -4.0F);

        this.frontRightLeg.addCuboid(-0.5F, -0.5F, -1.5F, 2, 3, 3);
        this.frontRightLeg.setPivot(3.0F, 2.5F, -4.0F);

        this.backRightLeg.addCube(2.5F, 0.0F, 2.5F, 2, 3, 3, 3.0F, 2.5F, 4.0F);
//        this.backRightLeg.addCuboid(2.5F, 0.0F, 2.5F, 2, 3, 3);
//        this.backRightLeg.setPivot(3.0F, 2.5F, 4.0F);

        this.frontLeftLeg.addCube(-4.5F, 0.0F, -5.5F, 2, 3, 3, -3.0F, 2.5F, -4.0F);
//        this.frontLeftLeg.addCuboid(-4.5F, 0.0F, -5.5F, 2, 3, 3);
//        this.frontLeftLeg.setPivot(-3.0F, 2.5F, -4.0F);

        this.backLeftLeg.addCube(-4.5F, 0.0F, 2.5F, 2, 3, 3, -3.0F, 2.5F, 4.0F);
//        this.backLeftLeg.addCuboid(-4.5F, 0.0F, 2.5F, 2, 3, 3);
//        this.backLeftLeg.setPivot(-3.0F, 2.5F, 4.0F);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.body.render(scale);
        this.frontRightLeg.render(scale);
        this.backRightLeg.render(scale);
        this.frontLeftLeg.render(scale);
        this.backLeftLeg.render(scale);
    }
}
