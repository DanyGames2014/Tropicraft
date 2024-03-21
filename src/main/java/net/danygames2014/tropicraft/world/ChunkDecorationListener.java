package net.danygames2014.tropicraft.world;

import net.danygames2014.tropicraft.world.feature.BambooPatchFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class ChunkDecorationListener {
    public static BambooPatchFeature bambooPatchFeature = new BambooPatchFeature();

    public static final boolean GENERATE_BAMBOO = true;

    // Chance is 1/value
    public static final int BAMBOO_GEN_CHANCE = 25;

    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension.id == 0) {
            decorateOverworld(event);
        }
    }

    public void decorateOverworld(WorldGenEvent.ChunkDecoration event) {
//        int x = event.x + event.random.nextInt(0, 15);
//        int z = event.z + event.random.nextInt(0, 15);
//        int topY = event.world.getTopY(x, z);
        if(
            (event.world.method_1781().method_1786(event.x, event.z) > 0.2D) && // Temperature is above 0.2
            (event.random.nextInt(BAMBOO_GEN_CHANCE) == 0)) // Bamboo Gen Chance
        {
            bambooPatchFeature.generate(event.world, event.random, event.x + 8, 0, event.z + 8);
        }
    }
}
