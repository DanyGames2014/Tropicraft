package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.block.TallFlowerBlock;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

public class FlowerPatchFeature extends Feature {
    public BlockState[] flowers;

    public FlowerPatchFeature() {
        flowers = new BlockState[]{
                Tropicraft.commelinaDiffusa.getDefaultState(),
                Tropicraft.crocosmia.getDefaultState(),
                Tropicraft.orchid.getDefaultState(),
                Tropicraft.canna.getDefaultState(),
                Tropicraft.anemone.getDefaultState(),
                Tropicraft.orange_anthurium.getDefaultState(),
                Tropicraft.red_anthurium.getDefaultState(),
                Tropicraft.magic_mushroom.getDefaultState(),
                Tropicraft.pathos.getDefaultState(),
                Tropicraft.acai_vine.getDefaultState(),
                Tropicraft.croton.getDefaultState(),
                Tropicraft.dracaena.getDefaultState(),
                Tropicraft.fern.getDefaultState(),
                Tropicraft.foliage.getDefaultState(),
                Tropicraft.bromeliad.getDefaultState(),
                Tropicraft.iris.getDefaultState().with(TallFlowerBlock.FLOWER_HALF, TallFlowerBlock.FlowerHalf.BOTTOM)
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
                world.setBlockState(x, y, z, flowers[random.nextInt(0, 16)]);
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
