package net.danygames2014.tropicraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class PoisonBlotEntity extends ArrowEntity {
    private int inAirTime = 0;

    public PoisonBlotEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.standingEyeHeight = 0.0F;
    }

    public PoisonBlotEntity(World world, double x, double y, double z) {
        this(world);
        this.setPos(x, y, z);
    }

    public PoisonBlotEntity(World world, LivingEntity owner) {
        this(world);

        this.owner = owner;
        this.setPositionAndAnglesKeepPrevAngles(owner.x, owner.y + (double) owner.getEyeHeight(), owner.z, owner.yaw, owner.pitch);

        this.x -= MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * 0.16F;
        this.y -= 0.1D;
        this.z -= MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * 0.16F;
        this.setPos(this.x, this.y, this.z);

        this.velocityX = -MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F);
        this.velocityZ = MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F);
        this.velocityY = -MathHelper.sin(this.pitch / 180.0F * 3.1415927F);
        this.setVelocity(this.velocityX, this.velocityY, this.velocityZ, 1.5F, 1.0F);
    }

    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        float var9 = MathHelper.sqrt(x * x + y * y + z * z);
        x /= var9;
        y /= var9;
        z /= var9;

        x += this.random.nextGaussian() * 0.0075 * (double) divergence;
        y += this.random.nextGaussian() * 0.0075 * (double) divergence;
        z += this.random.nextGaussian() * 0.0075 * (double) divergence;

        x *= speed;
        y *= speed;
        z *= speed;

        this.velocityX = x;
        this.velocityY = y;
        this.velocityZ = z;

        float var10 = MathHelper.sqrt(x * x + z * z);
        this.prevYaw = this.yaw = (float) (Math.atan2(x, z) * 180.0 / 3.1415927410125732);
        this.prevPitch = this.pitch = (float) (Math.atan2(y, var10) * 180.0 / 3.1415927410125732);
    }

    @Environment(EnvType.CLIENT)
    public void setVelocityClient(double x, double y, double z) {
        this.velocityX = x;
        this.velocityY = y;
        this.velocityZ = z;

        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            this.prevPitch = this.pitch;
            this.prevYaw = this.yaw;
            this.setPositionAndAnglesKeepPrevAngles(this.x, this.y, this.z, this.yaw, this.pitch);
        }
    }

    public void tick() {
        ++this.inAirTime;

        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            float var1 = MathHelper.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
            this.prevYaw = this.yaw = (float) (Math.atan2(this.velocityX, this.velocityZ) * 180.0 / 3.1415927410125732);
            this.prevPitch = this.pitch = (float) (Math.atan2(this.velocityY, var1) * 180.0 / 3.1415927410125732);
        }

        Vec3d var16 = Vec3d.createCached(this.x, this.y, this.z);
        Vec3d var17 = Vec3d.createCached(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
        HitResult hitResult = this.world.raycast(var16, var17, false, true);
        var16 = Vec3d.createCached(this.x, this.y, this.z);
        var17 = Vec3d.createCached(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
        if (hitResult != null) {
            var17 = Vec3d.createCached(hitResult.pos.x, hitResult.pos.y, hitResult.pos.z);
        }

        Entity var4 = null;
        List entities = this.world.getEntities(this, this.boundingBox.stretch(this.velocityX, this.velocityY, this.velocityZ).expand(1.0, 1.0, 1.0));
        double var6 = 0.0;

        for (Object object : entities) {
            Entity entity = (Entity) object;
            if (entity.isCollidable() && (entity != this.owner || this.inAirTime >= 5)) {
                Box var11 = entity.boundingBox.expand(0.3F, 0.3F, 0.3F);
                HitResult var12 = var11.raycast(var16, var17);
                if (var12 != null) {
                    double var13 = var16.distanceTo(var12.pos);
                    if (var13 < var6 || var6 == 0.0) {
                        var4 = entity;
                        var6 = var13;
                    }
                }
            }
        }

        if (var4 != null) {
            hitResult = new HitResult(var4);
        }

        if (hitResult != null) {
            if (hitResult.entity != null) {
                if (hitResult.entity.damage(this.owner, 4)) {
                    //this.world.playSound(this, "random.drr", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                    this.markDead();
                } else {
                    this.velocityX *= -0.10000000149011612;
                    this.velocityY *= -0.10000000149011612;
                    this.velocityZ *= -0.10000000149011612;
                    this.yaw += 180.0F;
                    this.prevYaw += 180.0F;
                    this.inAirTime = 0;
                }
            } else {
                this.markDead();
            }
        }

        this.x += this.velocityX;
        this.y += this.velocityY;
        this.z += this.velocityZ;
        this.yaw = (float) (Math.atan2(this.velocityX, this.velocityZ) * 180.0 / 3.1415927410125732);

        while (this.pitch - this.prevPitch >= 180.0F) {
            this.prevPitch += 360.0F;
        }

        while (this.yaw - this.prevYaw < -180.0F) {
            this.prevYaw -= 360.0F;
        }

        while (this.yaw - this.prevYaw >= 180.0F) {
            this.prevYaw += 360.0F;
        }

        this.pitch = this.prevPitch + (this.pitch - this.prevPitch) * 0.2F;
        this.yaw = this.prevYaw + (this.yaw - this.prevYaw) * 0.2F;

        if (this.isSubmergedInWater()) {
            this.markDead();
        }

        this.velocityX *= 0.99F;
        this.velocityY *= 0.99F;
        this.velocityZ *= 0.99F;
        this.velocityY -= 0.03F;
        this.setPos(this.x, this.y, this.z);
    }

    public void writeNbt(NbtCompound nbt) {
    }

    public void readNbt(NbtCompound nbt) {
    }

    @Override
    public void onPlayerInteraction(PlayerEntity player) {
        // We are not picking up poison from the ground :-)
    }
}
