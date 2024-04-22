package net.danygames2014.tropicraft.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;

public class BeachChairModel extends EntityModel {
    public ModelPart New_Shape1 = new ModelPart(0, 0);
    public ModelPart New_Shape2;
    public ModelPart New_Shape3;
    public ModelPart New_Shape31;
    public ModelPart New_Shape32;
    public ModelPart New_Shape321;
    public ModelPart New_Shape4;
    public ModelPart New_Shape41;

    public BeachChairModel() {
        this.New_Shape1.addCuboid(-7.0f, 0.0f, -8.0f, 16, 1, 16, 0.0f);
        this.New_Shape1.setPivot(-1.0f, 0.0f, 0.0f);
        this.New_Shape1.pitch = 0.0f;
        this.New_Shape1.yaw = 0.0f;
        this.New_Shape1.roll = 0.0f;
        this.New_Shape1.mirror = false;
        this.New_Shape2 = new ModelPart(0, 0);
        this.New_Shape2.addCuboid(-7.0f, 0.0f, 0.0f, 16, 1, 16, 0.0f);
        this.New_Shape2.setPivot(-1.0f, 0.0f, 8.0f);
        this.New_Shape2.pitch = 1.169371f;
        this.New_Shape2.yaw = 0.0f;
        this.New_Shape2.roll = 0.0f;
        this.New_Shape2.mirror = false;
        this.New_Shape3 = new ModelPart(0, 0);
        this.New_Shape3.addCuboid(-1.0f, -1.0f, 0.0f, 1, 10, 1, 0.0f);
        this.New_Shape3.setPivot(-8.0f, -3.0f, 6.0f);
        this.New_Shape3.pitch = 0.4537856f;
        this.New_Shape3.yaw = 0.0f;
        this.New_Shape3.roll = 0.0f;
        this.New_Shape3.mirror = false;
        this.New_Shape31 = new ModelPart(0, 0);
        this.New_Shape31.addCuboid(0.0f, 0.0f, 0.0f, 1, 10, 1, 0.0f);
        this.New_Shape31.setPivot(8.0f, -4.0f, 5.0f);
        this.New_Shape31.pitch = 0.4537856f;
        this.New_Shape31.yaw = 0.0f;
        this.New_Shape31.roll = 0.0f;
        this.New_Shape31.mirror = false;
        this.New_Shape32 = new ModelPart(0, 0);
        this.New_Shape32.addCuboid(0.0f, 0.0f, -1.0f, 1, 10, 1, 0.0f);
        this.New_Shape32.setPivot(8.0f, -4.0f, 0.0f);
        this.New_Shape32.pitch = -0.4537856f;
        this.New_Shape32.yaw = 0.0f;
        this.New_Shape32.roll = 0.0f;
        this.New_Shape32.mirror = false;
        this.New_Shape321 = new ModelPart(0, 0);
        this.New_Shape321.addCuboid(-1.0f, 0.0f, -1.0f, 1, 10, 1, 0.0f);
        this.New_Shape321.setPivot(-8.0f, -4.0f, 0.0f);
        this.New_Shape321.pitch = -0.4537856f;
        this.New_Shape321.yaw = 0.0f;
        this.New_Shape321.roll = 0.0f;
        this.New_Shape321.mirror = false;
        this.New_Shape4 = new ModelPart(0, 29);
        this.New_Shape4.addCuboid(0.0f, -1.0f, 0.0f, 14, 1, 2, 0.0f);
        this.New_Shape4.setPivot(-10.0f, -4.0f, 11.0f);
        this.New_Shape4.pitch = 0.0f;
        this.New_Shape4.yaw = 1.570796f;
        this.New_Shape4.roll = 0.0f;
        this.New_Shape4.mirror = false;
        this.New_Shape41 = new ModelPart(0, 29);
        this.New_Shape41.addCuboid(0.0f, 0.0f, 0.0f, 14, 1, 2, 0.0f);
        this.New_Shape41.setPivot(8.0f, -5.0f, 11.0f);
        this.New_Shape41.pitch = 0.0f;
        this.New_Shape41.yaw = 1.570796f;
        this.New_Shape41.roll = 0.0f;
        this.New_Shape41.mirror = false;
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.New_Shape1.render(scale);
        this.New_Shape2.render(scale);
        this.New_Shape3.render(scale);
        this.New_Shape31.render(scale);
        this.New_Shape32.render(scale);
        this.New_Shape321.render(scale);
        this.New_Shape4.render(scale);
        this.New_Shape41.render(scale);
    }

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
    }
}
