package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 2, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class AttackingAnimalEntity extends AnimalEntity {
    public int attackDamage = 1;

    public AttackingAnimalEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.9F, 1.3F);
    }

    public void setAttackDamage(int attackDamage){
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean canSpawn() {
        int blockX = MathHelper.floor(this.x);
        int blockY = MathHelper.floor(this.boundingBox.minY);
        int blockZ = MathHelper.floor(this.z);
        return this.world.getBlockState(blockX, blockY -1, blockZ).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("bamboo_grows_on"))) && this.world.getBrightness(blockX, blockY, blockZ) > 8;
    }

    @Override
    protected void attack(Entity other, float distance) {
        if (distance > 2.0F && distance < 6.0F && this.random.nextInt(10) == 0 && this.onGround) {
            double distanceX = other.x - this.x;
            double distanceZ = other.z - this.z;
            float distance2 = MathHelper.sqrt(distanceX * distanceX + distanceZ * distanceZ);
            this.velocityX = ((distanceX / (double) distance2) * 0.5D * 0.8D) + (this.velocityX * 0.2D);
            this.velocityZ = ((distanceZ / (double) distance2) * 0.5D * 0.8D) + (this.velocityZ * 0.2D);
            this.velocityY = 0.4D;
        } else {
            if (this.attackCooldown <= 0 && distance < 2.0F && other.boundingBox.maxY > this.boundingBox.minY && other.boundingBox.minY < this.boundingBox.maxY) {
                this.attackCooldown = 20;
                other.damage(this, this.attackDamage);
            }
        }
    }
}
