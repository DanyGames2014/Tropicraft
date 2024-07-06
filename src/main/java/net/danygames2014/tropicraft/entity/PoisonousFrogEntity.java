package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class PoisonousFrogEntity extends FrogEntity {

    public PoisonousFrogEntity(World world) {
        super(world);
    }

    @Override
    protected int getDroppedId() {
        return Tropicraft.poisonousFrogSkin.id;
    }

    @Override
    public boolean damage(Entity damageSource, int amount) {
        if (world.isRemote) {
            return false;
        }

        if (damageSource instanceof PlayerEntity && world.difficulty >= 1) {
            this.target = damageSource;
        }

        return super.damage(damageSource, amount);
    }

    @Override
    public void tick() {
        super.tick();

        if (world.isRemote) {
            return;
        }

        if (world.difficulty >= 1) {
            if (target != null) {
                if (getDistance(this.target) > 16F) {
                    target = null;
                }
            } else {
                target = world.getClosestPlayer(this.x, this.y, this.z, 8D);
            }
        } else {
            target = null;
        }
    }

    @Override
    protected void attack(Entity other, float distance) {
        if (world.isRemote || world.difficulty == 0 || distance > 4F) {
            return;
        }

        double xPos = other.x - this.x;
        double zPos = other.z - this.z;

        if (this.attackCooldown == 0) {
            PoisonBlotEntity blot = new PoisonBlotEntity(this.world, this);
            blot.y++;
            double var8 = other.y + (double) other.getEyeHeight() - 0.2D - blot.y;
            float var10 = MathHelper.sqrt(xPos * xPos + zPos * zPos) * 0.2F;
            this.world.playSound(this, "tropicraft:entity.frog.spit", 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
            this.world.spawnEntity(blot);
            blot.setVelocity(xPos, var8 + (double) var10, zPos, 0.6F, 24.0F);
            this.attackCooldown = 50;
        }

        this.yaw = (float) (Math.atan2(zPos, xPos) * 180.0 / 3.1415927410125732) - 90.0F;

        if(other instanceof PlayerEntity player){
            player.heal(20);
        }
    }

    public static class RedPoisonousFrogEntity extends PoisonousFrogEntity {
        public RedPoisonousFrogEntity(World world) {
            super(world);
        }
    }

    public static class BluePoisonousFrogEntity extends PoisonousFrogEntity {
        public BluePoisonousFrogEntity(World world) {
            super(world);
        }
    }

    public static class YellowPoisonousFrogEntity extends PoisonousFrogEntity {
        public YellowPoisonousFrogEntity(World world) {
            super(world);
        }
    }
}
