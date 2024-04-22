package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

public class FlowerPatchFeature extends Feature {
    public Block[] flowers;

    public FlowerPatchFeature() {
        flowers = new Block[]{
                Tropicraft.commelinaDiffusa,
                Tropicraft.crocosmia,
                Tropicraft.orchid,
                Tropicraft.canna,
                Tropicraft.anemone,
                Tropicraft.orange_anthurium,
                Tropicraft.red_anthurium,
                Tropicraft.magic_mushroom,
                Tropicraft.pathos,
                Tropicraft.acai_vine,
                Tropicraft.croton,
                Tropicraft.dracaena,
                Tropicraft.fern,
                Tropicraft.foliage,
                Tropicraft.bromeliad,
                Tropicraft.iris
        };
    }

    @Override
    public boolean generate(World world, Random random, int xCoord, int yCoord, int zCoord) {
        int retriesRemaining = 20;
        for (int i = 0; i < random.nextInt(Tropicraft.WORLDGEN_CONFIG.flower.minimumFlowers, Tropicraft.WORLDGEN_CONFIG.flower.maximumFlowers + 1); i++) {
            int x = xCoord + random.nextInt(0, 12) + 2;
            int z = zCoord + random.nextInt(0, 12) + 2;
            int y = world.getTopY(x, z);

            if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("flower_grows_on")))) {
                world.setBlockState(x, y, z, flowers[random.nextInt(0, 16)].getDefaultState());
            } else {
                if (retriesRemaining > 0) {
                    i--;
                    retriesRemaining--;
                }
            }
        }
        return true;
    }
}
