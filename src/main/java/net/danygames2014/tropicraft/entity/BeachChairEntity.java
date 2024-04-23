package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.mixin.LivingEntityAccessor;
import net.danygames2014.tropicraft.util.MathHelper;
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
        super.tick();

        if(!world.isRemote){
            // If on ground, allow the chair jumping code to run
            if (this.field_1623) {
                if (this.field_1594 != null && this.field_1594 instanceof PlayerEntity player) {
                    LivingEntityAccessor playerA = (LivingEntityAccessor) player;
                    if (playerA.jumping()) {
                        System.out.println(playerA.rightMovement());
                        if (playerA.rightMovement() > 0.9F) {
                            this.yaw -= random.nextFloat(5.0F, 10.0F);
                            this.method_1322(0, 0.2D, 0);
                        } else if (playerA.rightMovement() < -0.9F) {
                            this.yaw += random.nextFloat(5.0F, 10.0F);
                            this.method_1322(0, 0.2D, 0);
                        }
                    }
                }
            }

            // If not on ground apply some gravity
            if (!this.field_1623) { // onGround
                this.method_1322(0, -0.07d, 0);
            }

            // If on ground, lower the velocity
            if (this.field_1623) {
                this.velocityX *= 0.7F;
                this.velocityZ *= 0.7F;

                if (Math.abs(this.velocityX) < 0.05F) {
                    this.velocityX = 0F;
                }

                if (Math.abs(this.velocityZ) < 0.05F) {
                    this.velocityZ = 0F;
                }
            }


            // Cap the velocity at 0.5d on each axis
            this.velocityX = MathHelper.clamp(this.velocityX, -0.5, 0.5);
            this.velocityY = MathHelper.clamp(this.velocityY, -0.5, 0.5);
            this.velocityZ = MathHelper.clamp(this.velocityZ, -0.5, 0.5);

            // Move
            this.move(this.velocityX, this.velocityY, this.velocityZ);
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
