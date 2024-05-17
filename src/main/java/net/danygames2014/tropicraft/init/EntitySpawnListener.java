package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.entity.IguanaEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.OverworldDimension;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeModificationEvent;

public class EntitySpawnListener {

    @EventListener
    public void registerEntitySpawn(BiomeModificationEvent event) {
        // Check vanilla biomes first
        if (event.biome == Biome.RAINFOREST || event.biome == Biome.SWAMPLAND) {
            // For hot and humid vanilla biomes, add with higher spawn rate
            event.biome.addPassiveEntity(IguanaEntity.class, 12);

        } else if (event.biome == Biome.SAVANNA || event.biome == Biome.DESERT || event.biome == Biome.SHRUBLAND || event.biome == Biome.FOREST || event.biome == Biome.PLAINS) {
            // For Normal and Tropic vanilla biomes add with a lower spawnrate
            event.biome.addPassiveEntity(IguanaEntity.class, 20);

        } else if (event.biome == Biome.ICE_DESERT || event.biome == Biome.HELL || event.biome == Biome.SKY || event.biome == Biome.TAIGA || event.biome == Biome.TUNDRA) {
            // For other Vanilla biomes, do not add
            return;
        } else {
            // For non vanilla biomes, don't add if it can snow there
            if (event.biome.canSnow()) {
                return;
            }

            // Do not add if not in Overworld (for now)
            if (!(event.world.dimension instanceof OverworldDimension)) {
                return;
            }

            // For non vanilla biomes, if it can rain add with a higher spawn rate, if not, add with a lower one
            if (event.biome.canRain()) {
                event.biome.addPassiveEntity(IguanaEntity.class, 12);
            } else {
                event.biome.addPassiveEntity(IguanaEntity.class, 20);
            }
        }
    }
}
