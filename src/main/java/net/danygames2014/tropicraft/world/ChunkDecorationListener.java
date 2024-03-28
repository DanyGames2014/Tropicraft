package net.danygames2014.tropicraft.world;

import net.danygames2014.tropicraft.world.feature.BambooPatchFeature;
import net.danygames2014.tropicraft.world.feature.PalmTreeFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class ChunkDecorationListener {
    public static BambooPatchFeature bambooPatchFeature = new BambooPatchFeature();
    public static PalmTreeFeature palmTreeFeature = new PalmTreeFeature();

    public static final boolean GENERATE_BAMBOO = true;

    // Chance is 1/value
    public static final int BAMBOO_GEN_CHANCE = 20;

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

        if (GENERATE_BAMBOO && (event.random.nextInt(BAMBOO_GEN_CHANCE) == 0)) {
            if ((event.world.method_1781().method_1786(event.x, event.z) > 0.5D)) { // Temperature is above 0.5
                bambooPatchFeature.generate(event.world, event.random, event.x + 8, 0, event.z + 8);
            }
        }

        if (event.random.nextInt(5) == 0) {
            palmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
        }
    }
}
