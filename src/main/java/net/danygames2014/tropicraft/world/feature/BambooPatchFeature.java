package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

import static net.danygames2014.tropicraft.Tropicraft.WORLDGEN_CONFIG;

public class BambooPatchFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int xPos, int yPos, int zPos) {
        int x = xPos + 8;
        int z = zPos + 8;
        int y = world.getTopY(x, z);

        // If the block isn't air, return
        if (!world.method_234(x, y, z)) {
            return false;
        }

        // Calculate the amount and spread used for this patch
        int amount = random.nextInt( WORLDGEN_CONFIG.bamboo.maxBambooCount - WORLDGEN_CONFIG.bamboo.minBambooCount) + WORLDGEN_CONFIG.bamboo.minBambooCount;
        int spread = random.nextInt(3) - 1 + (int) (Math.sqrt(amount) / 2.0);

        // Spawn <amount> bamboo stalks
        for (int l = 0; l < amount; ++l) {
            int bambooX = x + random.nextInt(spread);
            int bambooZ = z + random.nextInt(spread);
            int bambooY = world.getTopY(bambooX, bambooZ) - 1;
            int height = random.nextInt(WORLDGEN_CONFIG.bamboo.maxBambooHeight - WORLDGEN_CONFIG.bamboo.minBambooHeight) + WORLDGEN_CONFIG.bamboo.minBambooHeight;
            BlockPos pos = new BlockPos(bambooX, bambooY, bambooZ);
            for (int h = 0; h < height; ++h) {
                pos = pos.up();
                // If the block isn't air or bamboo can't grow on it, continue
                if (!world.method_234(pos.x, pos.y, pos.z) || !Tropicraft.bambooShootBlock.canGrow(world, pos.x, pos.y, pos.z)) {
                    continue;
                }
                world.setBlock(pos.x, pos.y, pos.z, Tropicraft.bambooShootBlock.id);
            }
        }
        return true;
    }
}
