package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.render.entity.model.EntityModel;

public class EIHModel extends EntityModel {
    public TropiModelPart base = new TropiModelPart(0,0);
    public TropiModelPart body = new TropiModelPart(34, 8);
    public TropiModelPart top = new TropiModelPart(0, 17);
    public TropiModelPart nose = new TropiModelPart(16, 0);
    public TropiModelPart mouth = new TropiModelPart(56, 11);
    public TropiModelPart leftEye = new TropiModelPart(56,7);
    public TropiModelPart rightEye = new TropiModelPart(56,7);

    public EIHModel() {
        this.base.addCube(-4F, 0F, -5F, 8, 8, 11, 0F,0F,0F);
        this.body.addCube(-4F, 8F, -1F, 8, 17,7,0F, 0F, 0F);
        this.top.addCube(-4F, 25F, -4F, 8,5,10,0F,0F,0F);
        this.nose.addCube(-1F,12F,-4F,2,13,3,0F,0F,0F);
        this.mouth.addCube(-1F,9F,-1.5F,3,3,1,0F,0F,0F);
        this.leftEye.addCube(-4F,22F,-2F,3,3,1,0F,0F,0F);
        this.rightEye.addCube(1F,22F,-2F,3,3,1, 0F,0F,0F);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        this.base.render(scale);
        this.body.render(scale);
        this.top.render(scale);
        this.nose.render(scale);
        this.mouth.render(scale);
        this.leftEye.render(scale);
        this.rightEye.render(scale);
    }
}
