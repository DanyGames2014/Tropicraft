package net.danygames2014.tropicraft.world;

import net.danygames2014.tropicraft.world.feature.BambooPatchFeature;
import net.danygames2014.tropicraft.world.feature.PalmTreeFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

import static net.danygames2014.tropicraft.Tropicraft.WORLDGEN_CONFIG;

public class ChunkDecorationListener {
    public static BambooPatchFeature bambooPatchFeature;
    public static PalmTreeFeature palmTreeFeature;

    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension.id == 0) {
            decorateOverworld(event);
        }
    }

    // TODO : Rewrite this to use WorldModificationEvent
    public void decorateOverworld(WorldGenEvent.ChunkDecoration event) {
//        int x = event.x + event.random.nextInt(0, 15);
//        int z = event.z + event.random.nextInt(0, 15);
//        int topY = event.world.getTopY(x, z);

        if (WORLDGEN_CONFIG.bamboo.generateBamboo && (event.random.nextInt(WORLDGEN_CONFIG.bamboo.bambooGenChance) == 0)) {
            if ((event.world.method_1781().method_1786(event.x, event.z) > 0.5D)) { // Temperature is above 0.5
                bambooPatchFeature.generate(event.world, event.random, event.x + 8, 0, event.z + 8);
            }
        }

        if (WORLDGEN_CONFIG.palm.generatePalms && event.random.nextInt(WORLDGEN_CONFIG.palm.palmGenChance) == 0) {
            palmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
        }
    }
}
