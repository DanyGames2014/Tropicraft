package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.biome.TropiBiome;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;

public class BiomeListener {
    //public static Biome TROPICS_OCEAN;
    public static TropiBiome TROPICS_OCEAN;
    public static TropiBiome TROPICS_DEEP_OCEAN;
    public static TropiBiome TROPICS_ISLAND;
    public static TropiBiome TROPICS_ISLAND_DEEP;

    public static TropiBiome TROPICS_BEACH;
    public static TropiBiome TROPICS;
    public static TropiBiome TROPICS_DUNES;
    public static TropiBiome TROPICS_RAINFOREST;
    public static TropiBiome TROPICS_ORCHARD;
    public static TropiBiome TROPICS_RIVER;
    public static TropiBiome TROPICS_PLAINS;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        // Water Biomes
        TROPICS_OCEAN = new TropiBiome(BiomeBuilder.start("tropics_ocean")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.SAND);
        
        TROPICS_DEEP_OCEAN = new TropiBiome(BiomeBuilder.start("tropics_deep_ocean")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.SAND);
        
        TROPICS_ISLAND = new TropiBiome(BiomeBuilder.start("tropics_island")
                .grassAndLeavesColor(0x08CA15)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Tropicraft.purifiedSand);
        
        TROPICS_ISLAND_DEEP = new TropiBiome(BiomeBuilder.start("tropics_island_deep")
                .grassAndLeavesColor(0x08CA15)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.GRASS_BLOCK);

        // Land Biomes
        TROPICS_BEACH = new TropiBiome(BiomeBuilder.start("tropics_beach")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.SAND);
        
        TROPICS = new TropiBiome(BiomeBuilder.start("tropics")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.GRASS_BLOCK);
        
        TROPICS_DUNES = new TropiBiome(BiomeBuilder.start("tropics_dunes")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.SAND);
        
        TROPICS_RAINFOREST = new TropiBiome(BiomeBuilder.start("tropics_rainforest")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.GRASS_BLOCK);
        
        TROPICS_ORCHARD = new TropiBiome(BiomeBuilder.start("tropics_orchard")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.GRASS_BLOCK);
        
        TROPICS_RIVER = new TropiBiome(BiomeBuilder.start("tropics_river")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.SAND);

        TROPICS_PLAINS = new TropiBiome(BiomeBuilder.start("tropics_plains")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build()).setSurfaceBlock(Block.GRASS_BLOCK);
    }
}
