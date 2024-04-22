package net.danygames2014.tropicraft.world;

import net.danygames2014.tropicraft.world.feature.BambooPatchFeature;
import net.danygames2014.tropicraft.world.feature.FlowerPatchFeature;
import net.danygames2014.tropicraft.world.feature.PalmTreeFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.WorldEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

import static net.danygames2014.tropicraft.Tropicraft.WORLDGEN_CONFIG;

public class ChunkDecorationListener {
    public static BambooPatchFeature bambooPatchFeature;
    public static PalmTreeFeature palmTreeFeature;
    public static FlowerPatchFeature flowerPatchFeature;

    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension.id == 0) {
            decorateOverworld(event);
        }
    }

    // TODO : Rewrite this to use WorldModificationEvent
    public void decorateOverworld(WorldGenEvent.ChunkDecoration event) {
        // Bamboo Patch
        if (WORLDGEN_CONFIG.bamboo.generateBamboo && (event.random.nextInt(WORLDGEN_CONFIG.bamboo.bambooGenChance) == 0)) {
            if ((event.world.method_1781().method_1786(event.x, event.z) > 0.5D)) { // Temperature is above 0.5
                bambooPatchFeature.generate(event.world, event.random, event.x + 8, 0, event.z + 8);
            }
        }

        // Palms
        if (WORLDGEN_CONFIG.palm.generatePalms && event.random.nextInt(WORLDGEN_CONFIG.palm.palmGenChance) == 0) {
            palmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
        }

        // Flowers
        if (WORLDGEN_CONFIG.flower.generateFlowers && event.random.nextInt(WORLDGEN_CONFIG.flower.flowerGenChance) == 0) {
            flowerPatchFeature.generate(event.world, event.random, event.x, 0, event.z);
        }
    }

    @EventListener
    public void initFeatures(WorldEvent.Init event) {
        bambooPatchFeature = new BambooPatchFeature();
        palmTreeFeature = new PalmTreeFeature();
        flowerPatchFeature = new FlowerPatchFeature();
    }
}
