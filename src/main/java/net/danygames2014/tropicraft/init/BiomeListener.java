package net.danygames2014.tropicraft.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;

public class BiomeListener {
    public static Biome TROPICS;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        TROPICS = BiomeBuilder.start("tropics").grassAndLeavesColor(9286496).precipitation(true).snow(false).noDimensionFeatures().build();
    }
}
