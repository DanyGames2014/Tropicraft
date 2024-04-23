package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.mixin.LivingEntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;

public class BeachChairEntity extends Entity implements EntitySpawnDataProvider {

    public BeachChairEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(1.0F, 1.0F);
        this.eyeHeight = this.spacingY / 2.0F;
    }

    public BeachChairEntity(World world, Double x, Double y, Double z) {
        super(world);
        //this.method_1340(x,y,z);
    }

    @Override
    public void tick() {
        this.method_1322(0, -0.05D, 0);
        super.tick();
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.yaw += 1F;


        if (this.field_1594 != null && this.field_1594 instanceof PlayerEntity player) {
            System.out.println("PLAYER");
            if (((LivingEntityAccessor) player).jumping()) {
                System.out.println("JUMP");
                this.method_1322(0, 0.1D, 0);
            }
        }
    }

    @Override
    protected boolean bypassesSteppingEffects() {
        return true;
    }

    @Override
    public Box method_1381() {
        return this.boundingBox;
    }

    @Override
    public Box method_1379(Entity arg) {
        return this.boundingBox;
    }

    @Override
    public boolean method_1380() { // canBePushed
        return true;
    }

    @Override
    public double method_1357() { // getMountedYOffset
        return -0.2125;
    }

    @Override
    public boolean method_1356() { // canBeCollidedWith
        return !this.dead;
    }

    @Override
    public void method_1382() { // updateRiderPosition
        if (this.field_1594 == null) {
            return;
        }
        double d = Math.cos((double) this.yaw * Math.PI / 45.0) * 0.0;
        double d1 = Math.sin((double) this.yaw * Math.PI / 45.0) * 0.0;
        this.field_1594.method_1340(this.x + d, this.y + this.method_1357() + this.field_1594.method_1385(), this.z + d1);
    }

    public boolean method_1323(PlayerEntity entityplayer) {
        if (this.field_1594 != null && this.field_1594 instanceof PlayerEntity && this.field_1594 != entityplayer) {
            return true;
        }
        if (!this.world.isRemote) {
            entityplayer.method_1376((Entity) this);
        }
        return true;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeNbt(NbtCompound nbt) {

    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("beach_chair");
    }
}
