package net.danygames2014.tropicraft.entity;

import net.minecraft.world.World;

public class FrogEntity extends AttackingAnimalEntity {
    public FrogEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.9F, 1.3F);
    }
}
