package net.danygames2014.tropicraft.world.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;

public class TropiBiome {
    public Biome biome;
    public Block surfaceBlock;
    
    public TropiBiome(Biome biome) {
        this.biome = biome;
    }
    
    public TropiBiome setSurfaceBlock(Block surfaceBlock) {
        this.surfaceBlock = surfaceBlock;
        return this;
    }
}
