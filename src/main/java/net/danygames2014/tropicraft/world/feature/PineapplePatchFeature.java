package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.block.PineappleBlock;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

import static net.danygames2014.tropicraft.Tropicraft.WORLDGEN_CONFIG;

public class PineapplePatchFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int xCoord, int yCoord, int zCoord) {
        int retriesRemaining = 15;
        for (int i = 0; i < random.nextInt(WORLDGEN_CONFIG.pineapple.minimumPineapples, WORLDGEN_CONFIG.pineapple.maximumPineapples + 1); i++) {
            int x = xCoord + random.nextInt(0, 12) + 2;
            int z = zCoord + random.nextInt(0, 12) + 2;
            int y = world.getTopY(x, z);

            if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("pineapple_grows_on")))) {
                world.setBlockState(x, y, z, Tropicraft.pineapple.getDefaultState().with(PineappleBlock.PINEAPPLE_HALF, PineappleBlock.PineappleHalf.BOTTOM));
                world.setBlockState(x, y+1, z, Tropicraft.pineapple.getDefaultState().with(PineappleBlock.PINEAPPLE_HALF, PineappleBlock.PineappleHalf.TOP));
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
