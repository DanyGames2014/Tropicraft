package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 2, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class TropiSkeletonEntity extends MonsterEntity implements MobSpawnDataProvider {
    public static ItemStack defaultHeldItem = new ItemStack(Tropicraft.bambooStickItem, 1);

    public TropiSkeletonEntity(World world) {
        super(world);
        this.health = 30;
        this.attackDamage = 5;
    }

    @Override
    public String getTexture() {
        return "/assets/tropicraft/stationapi/textures/entity/tropiskeleton/tropiskeleton.png";
    }

    @Override
    public boolean canSpawn() {
        int spawnX = MathHelper.floor(this.x);
        int spawnY;
        int spawnZ;

        return this.world.getBlockId(
                spawnX,
                (spawnY = MathHelper.floor(this.boundingBox.minY)) - 1,
                spawnZ = MathHelper.floor(this.z)
        ) == Block.SAND.id && this.world.getBrightness(spawnX, spawnY, spawnZ) > 8;
    }

    @Override
    protected String getRandomSound() {
        return "mob.skeleton";
    }

    @Override
    protected String getHurtSound() {
        return "mob.skeletonhurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.skeletonhurt";
    }

    @Override
    protected int getDroppedItemId() {
        return Item.ARROW.id;
    }

    @Override
    protected void dropItems() {
        int amount = this.random.nextInt(3);
        for (int i = 0; i < amount; ++i) {
            this.dropItem(Item.BONE.id, 1);
        }
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("tropiskeleton");
    }
}
