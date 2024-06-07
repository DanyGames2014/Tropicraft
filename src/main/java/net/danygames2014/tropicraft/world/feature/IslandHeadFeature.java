package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.structure.CollisionType;
import net.danygames2014.tropicraft.world.structure.Structure;
import net.danygames2014.tropicraft.world.structure.StructureBlockEntry;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

public class IslandHeadFeature extends Feature {
    Structure islandHeadStructure;
    StructureBlockEntry treasureBlockEntry1;
    StructureBlockEntry treasureBlockEntry2;

    public IslandHeadFeature(World world) {
        this.islandHeadStructure = new Structure(world);

        // Layer 1
        islandHeadStructure.addBlock(1, -2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, -2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -2, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -2, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, -2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, -2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -2, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -2, 4, Tropicraft.chunkOHead);

        // Layer 2
        islandHeadStructure.addBlock(1, -1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, -1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -1, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -1, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, -1, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -1, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, -1, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, -1, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, -1, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, -1, 4, Tropicraft.chunkOHead);

        // Layer 3
        islandHeadStructure.addBlock(1, 0, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 0, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 0, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 0, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 0, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 0, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 0, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 0, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 0, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 0, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 0, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 0, 4, Tropicraft.chunkOHead);

        // Layer 4
        islandHeadStructure.addBlock(2, 1, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 1, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 1, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 1, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 1, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 1, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 1, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 1, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 1, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 1, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 1, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 1, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 1, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 1, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 1, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 1, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 1, 5, Tropicraft.chunkOHead);

        // Layer 5
        islandHeadStructure.addBlock(2, 2, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 2, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 2, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 2, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 2, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 2, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 2, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 2, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 2, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 2, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 2, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 2, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 2, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 2, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 2, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 2, 5, Tropicraft.chunkOHead);

        // Layer 6
        islandHeadStructure.addBlock(2, 3, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 3, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 3, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 3, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 3, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 3, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 3, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 3, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 3, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 3, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 3, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 3, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 3, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 3, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 3, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 3, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 3, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 3, 4, Tropicraft.chunkOHead);

        // Layer 7
        islandHeadStructure.addBlock(1, 4, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 4, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 4, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 4, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 4, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 4, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 4, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 4, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 4, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 4, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 4, 3, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 4, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 4, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 4, 5, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 4, 5, Tropicraft.chunkOHead);

        // Layer 8
        islandHeadStructure.addBlock(1, 5, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 5, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 5, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 5, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(0, 5, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 5, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(2, 5, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 5, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 5, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(5, 5, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(0, 5, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 5, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(2, 5, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 5, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 5, 2, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(5, 5, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 5, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 5, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 5, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 5, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 5, 4, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 5, 4, Tropicraft.chunkOHead);

        // Layer 9
        islandHeadStructure.addBlock(1, 6, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 6, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 6, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 6, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(0, 6, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 6, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(2, 6, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(3, 6, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(4, 6, 1, Block.FLOWING_LAVA);
        islandHeadStructure.addBlock(5, 6, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(0, 6, 2, Tropicraft.chunkOHead);
        treasureBlockEntry1 = new StructureBlockEntry(1, 6, 2, Block.GLOWSTONE, CollisionType.REPLACE_BLOCK);
        islandHeadStructure.addBlock(treasureBlockEntry1);
        islandHeadStructure.addBlock(2, 6, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 6, 2, Tropicraft.chunkOHead);
        treasureBlockEntry2 = new StructureBlockEntry(4, 6, 2, Block.GLOWSTONE, CollisionType.REPLACE_BLOCK);
        islandHeadStructure.addBlock(treasureBlockEntry2);
        islandHeadStructure.addBlock(5, 6, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 6, 3, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 6, 3, Tropicraft.chunkOHead);

        // Layer 10
        islandHeadStructure.addBlock(1, 7, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 7, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 7, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 7, 0, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 7, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 7, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 7, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 7, 1, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(1, 7, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(2, 7, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(3, 7, 2, Tropicraft.chunkOHead);
        islandHeadStructure.addBlock(4, 7, 2, Tropicraft.chunkOHead);

        for (var block : islandHeadStructure.blocks) {
            block.yOffset--;

            if (block.yOffset >= 1) {
                block.collisionType = CollisionType.DONT_GENERATE;
            } else {
                block.collisionType = CollisionType.REPLACE_BLOCK;
            }
        }
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        BlockState treasureState = getTreasureState(random);
        treasureBlockEntry1.state = treasureState;
        treasureBlockEntry2.state = treasureState;

        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("island_head_generates_on")))) {
            return islandHeadStructure.generate(world, x, y, z);
        }

        return false;
    }

    public BlockState getTreasureState(Random random) {
        return switch (random.nextInt(6)) {
            case 1 -> Block.OBSIDIAN.getDefaultState();
            case 2 -> Block.DIAMOND_BLOCK.getDefaultState();
            case 3 -> Block.IRON_BLOCK.getDefaultState();
            case 4 -> Block.GOLD_BLOCK.getDefaultState();
            case 5 -> Block.LAPIS_BLOCK.getDefaultState();
            default -> Block.GLOWSTONE.getDefaultState();
        };
    }
}
