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

public class SmallPalmTreeFeature extends Feature {

    TreeStructure structure;

    public SmallPalmTreeFeature(World world) {
        BlockState palmLog = Tropicraft.palmLog.getDefaultState();
        BlockState palmLeaves = Tropicraft.palmLeaves.getDefaultState();

        this.structure = new TreeStructure(world,palmLog, CollisionType.DONT_GENERATE);

        // Center Log and Leaf around it
        structure.addBlock(0, 0, 0, palmLog);
        structure.addBlock(0, 1, 0, palmLeaves);
        structure.addBlock(1, 0, 0, palmLeaves);
        structure.addBlock(1, 0, 1, palmLeaves);
        structure.addBlock(1, 0, -1, palmLeaves);
        structure.addBlock(-1, 0, 0, palmLeaves);
        structure.addBlock(-1, 0, 1, palmLeaves);
        structure.addBlock(-1, 0, -1, palmLeaves);
        structure.addBlock(0, 0, 1, palmLeaves);
        structure.addBlock(0, 0, -1, palmLeaves);

        // Leaves to side
        structure.addBlock(2, 0, 0, palmLeaves);
        structure.addBlock(3, 0, 0, palmLeaves);
        structure.addBlock(-2, 0, 0, palmLeaves);
        structure.addBlock(-3, 0, 0, palmLeaves);
        structure.addBlock(0, 0, 2, palmLeaves);
        structure.addBlock(0, 0, 3, palmLeaves);
        structure.addBlock(0, 0, -2, palmLeaves);
        structure.addBlock(0, 0, -3, palmLeaves);
        structure.addBlock(4, -1, 0, palmLeaves);
        structure.addBlock(-4, -1, 0, palmLeaves);
        structure.addBlock(0, -1, 4, palmLeaves);
        structure.addBlock(0, -1, -4, palmLeaves);

        // Diagonal leaves to side
        structure.addBlock(2, 0, 2, palmLeaves);
        structure.addBlock(2, 0, -2, palmLeaves);
        structure.addBlock(-2, 0, 2, palmLeaves);
        structure.addBlock(-2, 0, -2, palmLeaves);
        structure.addBlock(3, -1, 3, palmLeaves);
        structure.addBlock(3, -1, -3, palmLeaves);
        structure.addBlock(-3, -1, 3, palmLeaves);
        structure.addBlock(-3, -1, -3, palmLeaves);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            return structure.generate(world, x, y, z, random.nextInt(6, 9));
        }
        return false;
    }
}
