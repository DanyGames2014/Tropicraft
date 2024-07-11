package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.entity.EIHEntity;
import net.danygames2014.tropicraft.entity.FrogEntity;
import net.danygames2014.tropicraft.entity.IguanaEntity;
import net.danygames2014.tropicraft.entity.PoisonousFrogEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.OverworldDimension;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeModificationEvent;

public class EntitySpawnListener {

    @EventListener
    public void registerEntitySpawn(BiomeModificationEvent event) {
        // Check vanilla biomes first
        if (event.biome == Biome.RAINFOREST || event.biome == Biome.SWAMPLAND) {
            /// Hot and humid vanilla biomes
            event.biome.addPassiveEntity(IguanaEntity.class, 16);
            event.biome.addPassiveEntity(FrogEntity.class, 10);
            event.biome.addPassiveEntity(PoisonousFrogEntity.RedPoisonousFrogEntity.class, 6);
            event.biome.addPassiveEntity(PoisonousFrogEntity.BluePoisonousFrogEntity.class, 8);

        } else if (event.biome == Biome.DESERT) {
            /// Desert Vanilla Biome
            event.biome.addPassiveEntity(IguanaEntity.class, 6);
            event.biome.addPassiveEntity(EIHEntity.class, 4);
            event.biome.addPassiveEntity(PoisonousFrogEntity.YellowPoisonousFrogEntity.class, 10);

        } else if (event.biome == Biome.SAVANNA || event.biome == Biome.SHRUBLAND) {
            /// Dry Vanilla biomes
            event.biome.addPassiveEntity(IguanaEntity.class, 10);
            event.biome.addPassiveEntity(EIHEntity.class, 4);

        } else if (event.biome == Biome.FOREST || event.biome == Biome.PLAINS) {
            // Temperate Vanilla Biomes
            event.biome.addPassiveEntity(IguanaEntity.class, 14);
            event.biome.addPassiveEntity(FrogEntity.class, 12);
            event.biome.addPassiveEntity(EIHEntity.class, 3);

        } else if (event.biome == Biome.ICE_DESERT || event.biome == Biome.HELL || event.biome == Biome.SKY || event.biome == Biome.TAIGA || event.biome == Biome.TUNDRA) {
            // Other Vanilla Biomes
            return;

        // Check modded biomes
        } else {
            // For modded biomes, don't add if it can snow there
            if (event.biome.canSnow()) {
                return;
            }

            // Do not add if not in Overworld (for now)
            if (!(event.world.dimension instanceof OverworldDimension)) {
                return;
            }

            // For non vanilla biomes, check if it can rain there
            if (event.biome.canRain()) {
                event.biome.addPassiveEntity(IguanaEntity.class, 16);
                event.biome.addPassiveEntity(FrogEntity.class, 12);
            } else {
                event.biome.addPassiveEntity(IguanaEntity.class, 8);
                event.biome.addPassiveEntity(FrogEntity.class, 6);
            }
        }
    }
}
