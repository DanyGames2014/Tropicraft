package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.mixin.LivingEntityAccessor;
import net.danygames2014.tropicraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 5, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class BeachChairEntity extends Entity implements EntitySpawnDataProvider {

    public BeachChairEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(1.0F, 1.0F);
        this.standingEyeHeight = this.height / 2.0F;
    }

    public BeachChairEntity(World world, Double x, Double y, Double z) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.setPos(x,y,z);
        this.standingEyeHeight = this.height / 2.0F;
    }

    @Override
    public void tick() {
        super.tick();
        if(!world.isRemote){
            // If on ground, allow the chair jumping code to run
            if (this.onGround) {
                if (this.passenger != null && this.passenger instanceof PlayerEntity player) {
                    LivingEntityAccessor playerA = (LivingEntityAccessor) player;
                    if (playerA.jumping()) {
                        System.out.println("JUMP");
                        System.out.println(playerA.rightMovement());
                        System.out.println(playerA.frontMovement());
                        if (playerA.rightMovement() > 0.9F) {
                            this.yaw -= random.nextFloat(5.0F, 10.0F);
                            this.addVelocity(0, 0.2D, 0);
                        } else if (playerA.rightMovement() < -0.9F) {
                            this.yaw += random.nextFloat(5.0F, 10.0F);
                            this.addVelocity(0, 0.2D, 0);
                        }
                    }
                }
            }

            // If not on ground apply some gravity
            if (!this.onGround) { // onGround
                this.addVelocity(0, -0.07d, 0);
            }

            // If on ground, lower the velocity
            if (this.onGround) {
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
    public Box getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    public Box method_1379(Entity arg) {
        return this.boundingBox;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public double getPassengerRidingHeight() {
        return -0.2125;
    }

    @Override
    public boolean isCollidable() {
        return !this.dead;
    }

    @Override
    public void updatePassengerPosition() {
        if (this.passenger == null) {
            return;
        }
        double d = Math.cos((double) this.yaw * Math.PI / 45.0) * 0.0;
        double d1 = Math.sin((double) this.yaw * Math.PI / 45.0) * 0.0;
        this.passenger.setPos(this.x + d, this.y + this.getPassengerRidingHeight() + this.passenger.getStandingEyeHeight(), this.z + d1);
    }

    public boolean method_1323(PlayerEntity entityplayer) {
        if (this.passenger != null && this.passenger instanceof PlayerEntity && this.passenger != entityplayer) {
            return true;
        }
        if (!this.world.isRemote) {
            entityplayer.setVehicle((Entity) this);
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
