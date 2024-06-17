package net.danygames2014.tropicraft.world;

import net.danygames2014.tropicraft.world.feature.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.world.WorldEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

import java.util.Random;

import static net.danygames2014.tropicraft.Tropicraft.WORLDGEN_CONFIG;

public class ChunkDecorationListener {
    public static BambooPatchFeature bambooPatchFeature;
    public static SmallPalmTreeFeature smallPalmTreeFeature;
    public static CurvedPalmTreeFeature curvedPalmTreeFeature;
    public static TallPalmTreeFeature tallPalmTreeFeature;
    public static FlowerPatchFeature flowerPatchFeature;
    public static PineapplePatchFeature pineapplePatchFeature;
    public static IslandHeadFeature islandHeadFeature;

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
            switch(event.random.nextInt(1,3)){
                case 0 -> {
                    smallPalmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
                }
                case 1 -> {
                    curvedPalmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
                }
                case 2 -> {
                    tallPalmTreeFeature.generate(event.world, event.random, event.x, 0, event.z);
                }
            }

        }

        // Flowers
        if (WORLDGEN_CONFIG.flower.generateFlowers && event.random.nextInt(WORLDGEN_CONFIG.flower.flowerGenChance) == 0) {
            flowerPatchFeature.generate(event.world, event.random, event.x, 0, event.z);
        }

        // Pineapple
        if (WORLDGEN_CONFIG.pineapple.generatePineapples && event.random.nextInt(WORLDGEN_CONFIG.pineapple.pineappleGenChance) == 0){
            pineapplePatchFeature.generate(event.world, event.random, event.x, 0, event.z);
        }

        // Island Heads
        if (WORLDGEN_CONFIG.islandHead.generateIslandHeads && event.random.nextInt(WORLDGEN_CONFIG.islandHead.islandHeadGenChance) == 0) {
            islandHeadFeature.generate(event.world, event.random, event.x, 0, event.z);
        }
    }

    @EventListener
    public void initFeatures(WorldEvent.Init event) {
        bambooPatchFeature = new BambooPatchFeature();
        smallPalmTreeFeature = new SmallPalmTreeFeature(event.world);
        flowerPatchFeature = new FlowerPatchFeature();
        pineapplePatchFeature = new PineapplePatchFeature();
        islandHeadFeature = new IslandHeadFeature(event.world);
        curvedPalmTreeFeature = new CurvedPalmTreeFeature(event.world);
        tallPalmTreeFeature = new TallPalmTreeFeature(event.world);
    }
}
