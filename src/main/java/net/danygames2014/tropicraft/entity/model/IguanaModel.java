package net.danygames2014.tropicraft.entity.model;

import net.danygames2014.tropicraft.util.TropiModelPart;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;

public class IguanaModel extends EntityModel {
    public ModelPart body = new TropiModelPart(0, 0);
    public ModelPart frontRightLeg = new TropiModelPart(0, 0);
    public ModelPart backRightLeg = new TropiModelPart(0, 0);
    public ModelPart frontLeftLeg = new TropiModelPart(0, 0);
    public ModelPart backLeftLeg = new TropiModelPart(0, 0);
    public ModelPart head = new TropiModelPart(0, 0);

    public IguanaModel() {
        this.body.addCuboid(-6.5F, 0.0F, -2.5F, 13, 3, 5);
        this.body.setPivot(0.0F, 0.0F, 0.0F);
        this.frontRightLeg.addCuboid(-5.5F, -1.0F, -4.5F, 3, 3, 2);
        this.frontRightLeg.setPivot(-4.0F, 1.0F, -3.0F);
        this.frontLeftLeg.addCuboid(-5.5F, -1.0F, 2.5F, 3, 3, 2);
        this.frontLeftLeg.setPivot(-4.0F, 1.0F, 3.0F);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.body.render(scale);
        this.frontRightLeg.render(scale);
        this.frontLeftLeg.render(scale);
    }
}
