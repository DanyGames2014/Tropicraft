package net.danygames2014.tropicraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class TropiCreeperEntity extends CreeperEntity {
    public TropiCreeperEntity(World world) {
        super(world);
    }

    @Override
    public String getTexture() {
        return "/assets/tropicraft/stationapi/textures/entity/tropicreeper/tropicreeper.png";
    }

    @Override
    public void attack(Entity other, float distance) {
        if (!this.world.isRemote) {
            int fuseSpeed = this.getFuseSpeed();
            if (fuseSpeed <= 0 && distance < 3.0F || fuseSpeed > 0 && distance < 7.0F) {
                if (this.fuseTime == 0) {
                    this.world.playSound(this, "tropicraft:entity.tropicreeper.fuse", 1.0F, 0.5F);
                }

                this.setFuseSpeed(1);
                ++this.fuseTime;
                if (this.fuseTime >= 30) {
                    this.explode(world, this, this.x, this.y, this.z, isCharged());
                    this.markDead();
                }

                this.movementBlocked = true;
            } else {
                this.setFuseSpeed(-1);
                --this.fuseTime;
                if (this.fuseTime < 0) {
                    this.fuseTime = 0;
                }
            }

        }
    }

    public void explode(World world, Entity entity, double x, double y, double z, boolean charged){

    }
}
