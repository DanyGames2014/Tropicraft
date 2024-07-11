package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

public class FrogEntity extends AttackingAnimalEntity {
    public FrogEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.7F);
        this.maxHealth = 4;
    }

    @Override
    public int getLimitPerChunk() {
        return 3;
    }

    @Override
    protected int getDroppedId() {
        return Tropicraft.frogLeg.id;
    }

    @Override
    protected String getRandomSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return null;
    }
}
