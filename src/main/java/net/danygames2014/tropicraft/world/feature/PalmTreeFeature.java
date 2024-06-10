package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.structure.CollisionType;
import net.danygames2014.tropicraft.world.structure.TreeStructure;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

public class PalmTreeFeature extends Feature {

    TreeStructure palmTreeStructure;

    public PalmTreeFeature(World world) {
        BlockState palmLog = Tropicraft.palmLog.getDefaultState();
        BlockState palmLeaves = Tropicraft.palmLeaves.getDefaultState();

        this.palmTreeStructure = new TreeStructure(world,palmLog, CollisionType.DONT_GENERATE);

        // Center Log and Leaf around it
        palmTreeStructure.addBlock(0, 0, 0, palmLog);
        palmTreeStructure.addBlock(0, 1, 0, palmLeaves);
        palmTreeStructure.addBlock(1, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(1, 0, 1, palmLeaves);
        palmTreeStructure.addBlock(1, 0, -1, palmLeaves);
        palmTreeStructure.addBlock(-1, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(-1, 0, 1, palmLeaves);
        palmTreeStructure.addBlock(-1, 0, -1, palmLeaves);
        palmTreeStructure.addBlock(0, 0, 1, palmLeaves);
        palmTreeStructure.addBlock(0, 0, -1, palmLeaves);

        // Leaves to side
        palmTreeStructure.addBlock(2, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(3, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(-2, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(-3, 0, 0, palmLeaves);
        palmTreeStructure.addBlock(0, 0, 2, palmLeaves);
        palmTreeStructure.addBlock(0, 0, 3, palmLeaves);
        palmTreeStructure.addBlock(0, 0, -2, palmLeaves);
        palmTreeStructure.addBlock(0, 0, -3, palmLeaves);
        palmTreeStructure.addBlock(4, -1, 0, palmLeaves);
        palmTreeStructure.addBlock(-4, -1, 0, palmLeaves);
        palmTreeStructure.addBlock(0, -1, 4, palmLeaves);
        palmTreeStructure.addBlock(0, -1, -4, palmLeaves);

        // Diagonal leaves to side
        palmTreeStructure.addBlock(2, 0, 2, palmLeaves);
        palmTreeStructure.addBlock(2, 0, -2, palmLeaves);
        palmTreeStructure.addBlock(-2, 0, 2, palmLeaves);
        palmTreeStructure.addBlock(-2, 0, -2, palmLeaves);
        palmTreeStructure.addBlock(3, -1, 3, palmLeaves);
        palmTreeStructure.addBlock(3, -1, -3, palmLeaves);
        palmTreeStructure.addBlock(-3, -1, 3, palmLeaves);
        palmTreeStructure.addBlock(-3, -1, -3, palmLeaves);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            return palmTreeStructure.generate(world, x, y, z, random.nextInt(6, 9));
        }
        return false;
    }
}
