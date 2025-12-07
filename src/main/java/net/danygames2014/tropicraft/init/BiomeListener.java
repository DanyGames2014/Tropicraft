package net.danygames2014.tropicraft.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;

public class BiomeListener {
    public static Biome TROPICS_BEACH;
    public static Biome TROPICS_OCEAN;
    public static Biome TROPICS_DEEP_OCEAN;
    public static Biome TROPICS_ISLAND;
    public static Biome TROPICS_ISLAND_DEEP;

    public static Biome TROPICS;
    public static Biome TROPICS_DUNES;
    public static Biome TROPICS_RAINFOREST;
    public static Biome TROPICS_ORCHARD;
    public static Biome TROPICS_RIVER;
    public static Biome TROPICS_PLAINS;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        TROPICS_BEACH = BiomeBuilder.start("tropics_dunes")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();
        
        TROPICS_OCEAN = BiomeBuilder.start("tropics_ocean")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();
        
        TROPICS_DEEP_OCEAN = BiomeBuilder.start("tropics_deep_ocean")
                .grassAndLeavesColor(9286496)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();
        
        TROPICS_ISLAND = BiomeBuilder.start("tropics_island")
                .grassAndLeavesColor(0x08CA15)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();
        
        TROPICS_ISLAND_DEEP = BiomeBuilder.start("tropics_island_deep")
                .grassAndLeavesColor(0x08CA15)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();

        TROPICS = BiomeBuilder.start("tropics")
                .grassAndLeavesColor(0x08FA36)
                .precipitation(true)
                .snow(false)
                .noDimensionFeatures()
                .build();
    }
}
