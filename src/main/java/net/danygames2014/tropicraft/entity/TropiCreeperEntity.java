package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import static net.danygames2014.tropicraft.util.MathHelper.distance;
import static net.danygames2014.tropicraft.world.feature.FlowerPatchFeature.flowers;

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
                    this.world.playSound(this, "tropicraft:entity.tropicreeper.fuse", 1.0F, 1.0F);
                }

                this.setFuseSpeed(1);
                ++this.fuseTime;
                if (this.fuseTime >= 30) {
                    this.explode(world, this, MathHelper.floor(this.x), MathHelper.floor(this.y), MathHelper.floor(this.z), isCharged());
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

    public void explode(World world, Entity entity, int x, int y, int z, boolean charged) {
        // TODO: Flower explosion

        int yPos;

        for (int xOffset = -3; xOffset < 4; xOffset++) {
            for (int zOffset = -3; zOffset < 4; zOffset++) {
                yPos = world.getTopY(x + xOffset, z + zOffset);

                if(!world.getBlockState(x + xOffset, yPos, z + zOffset).isAir()){
                    continue;
                }

                if(!world.getBlockState(x + xOffset, yPos - 1, z + zOffset).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("flower_grows_on")))){
                    continue;
                }

                if (distance(x, y, z, x + xOffset, yPos, z + zOffset) > 2.5D) {
                    continue;
                }

                world.setBlockStateWithNotify(x + xOffset, yPos, z + zOffset, flowers[random.nextInt(0, 16)]);
            }
        }
    }
}
