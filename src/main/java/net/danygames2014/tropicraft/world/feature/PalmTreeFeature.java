package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.util.Structure;
import net.danygames2014.tropicraft.util.TreeStructure;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class PalmTreeFeature extends Feature {

    TreeStructure palmTreeStructure;

    public PalmTreeFeature() {
        Identifier palmLogId = Tropicraft.NAMESPACE.id("palm_log");
        Identifier palmLeavesId = Tropicraft.NAMESPACE.id("palm_leaves");

        this.palmTreeStructure = new TreeStructure(palmLogId, Structure.CollisionType.DONT_GENERATE);

        // Center Log and Leaf around it
        palmTreeStructure.addBlock(0, 0, 0, palmLogId);
        palmTreeStructure.addBlock(0, 1, 0, palmLeavesId);
        palmTreeStructure.addBlock(1, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(1, 0, 1, palmLeavesId);
        palmTreeStructure.addBlock(1, 0, -1, palmLeavesId);
        palmTreeStructure.addBlock(-1, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(-1, 0, 1, palmLeavesId);
        palmTreeStructure.addBlock(-1, 0, -1, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, 1, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, -1, palmLeavesId);

        // Leaves to side
        palmTreeStructure.addBlock(2, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(3, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(-2, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(-3, 0, 0, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, 2, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, 3, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, -2, palmLeavesId);
        palmTreeStructure.addBlock(0, 0, -3, palmLeavesId);
        palmTreeStructure.addBlock(4, -1, 0, palmLeavesId);
        palmTreeStructure.addBlock(-4, -1, 0, palmLeavesId);
        palmTreeStructure.addBlock(0, -1, 4, palmLeavesId);
        palmTreeStructure.addBlock(0, -1, -4, palmLeavesId);

        // Diagonal leaves to side
        palmTreeStructure.addBlock(2, 0, 2, palmLeavesId);
        palmTreeStructure.addBlock(2, 0, -2, palmLeavesId);
        palmTreeStructure.addBlock(-2, 0, 2, palmLeavesId);
        palmTreeStructure.addBlock(-2, 0, -2, palmLeavesId);
        palmTreeStructure.addBlock(3, -1, 3, palmLeavesId);
        palmTreeStructure.addBlock(3, -1, -3, palmLeavesId);
        palmTreeStructure.addBlock(-3, -1, 3, palmLeavesId);
        palmTreeStructure.addBlock(-3, -1, -3, palmLeavesId);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            return palmTreeStructure.generate(world, x, y, z, random.nextInt(6, 9)); //
        }
        return false;
    }
}
