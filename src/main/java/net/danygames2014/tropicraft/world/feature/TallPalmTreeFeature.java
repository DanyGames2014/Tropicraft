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

public class TallPalmTreeFeature extends Feature {
    TreeStructure structure;

    public TallPalmTreeFeature(World world) {
        BlockState palmLog = Tropicraft.palmLog.getDefaultState();
        BlockState palmLeaves = Tropicraft.palmLeaves.getDefaultState();

        this.structure = new TreeStructure(world, palmLog, CollisionType.DONT_GENERATE);

        // Wooden Core above trunk
        structure.addBlock(0,0,0, palmLog);
        structure.addBlock(1,0,0, palmLog);
        structure.addBlock(-1,0,0, palmLog);
        structure.addBlock(0,0,1, palmLog);
        structure.addBlock(0,0,-1, palmLog);

        // Center Leaves
        structure.addBlock(0,1,0, palmLeaves);
        structure.addBlock(1,1,0, palmLeaves);
        structure.addBlock(-1,1,0, palmLeaves);
        structure.addBlock(0,1,1, palmLeaves);
        structure.addBlock(0,1,-1, palmLeaves);
        structure.addBlock(1,1,1, palmLeaves);
        structure.addBlock(1,1,-1, palmLeaves);
        structure.addBlock(-1,1,1, palmLeaves);
        structure.addBlock(-1,1,-1, palmLeaves);

        // Center Leaves Above Ring
        structure.addBlock(1,2,0, palmLeaves);
        structure.addBlock(-1,2,0, palmLeaves);
        structure.addBlock(0,2,1, palmLeaves);
        structure.addBlock(0,2,-1, palmLeaves);
        structure.addBlock(1,2,1, palmLeaves);
        structure.addBlock(1,2,-1, palmLeaves);
        structure.addBlock(-1,2,1, palmLeaves);
        structure.addBlock(-1,2,-1, palmLeaves);

        // Side Leaves X+
        structure.addBlock(2,1,-1, palmLeaves);
        structure.addBlock(3,1,-1, palmLeaves);
        structure.addBlock(4,1,-1, palmLeaves);
        structure.addBlock(5,1,-1, palmLeaves);
        structure.addBlock(2,1,1, palmLeaves);
        structure.addBlock(3,1,1, palmLeaves);
        structure.addBlock(4,1,1, palmLeaves);
        structure.addBlock(5,1,1, palmLeaves);

        structure.addBlock(2,2,0, palmLeaves);
        structure.addBlock(3,2,0, palmLeaves);
        structure.addBlock(4,2,0, palmLeaves);
        structure.addBlock(5,2,0, palmLeaves);

        structure.addBlock(6,0,-1, palmLeaves);
        structure.addBlock(6,0,1, palmLeaves);
        structure.addBlock(6,1,0, palmLeaves);

        structure.addBlock(7,0,0, palmLeaves);

        // Side Leaves X-
        structure.addBlock(-2,1,-1, palmLeaves);
        structure.addBlock(-3,1,-1, palmLeaves);
        structure.addBlock(-4,1,-1, palmLeaves);
        structure.addBlock(-5,1,-1, palmLeaves);
        structure.addBlock(-2,1,1, palmLeaves);
        structure.addBlock(-3,1,1, palmLeaves);
        structure.addBlock(-4,1,1, palmLeaves);
        structure.addBlock(-5,1,1, palmLeaves);

        structure.addBlock(-2,2,0, palmLeaves);
        structure.addBlock(-3,2,0, palmLeaves);
        structure.addBlock(-4,2,0, palmLeaves);
        structure.addBlock(-5,2,0, palmLeaves);

        structure.addBlock(-6,0,-1, palmLeaves);
        structure.addBlock(-6,0,1, palmLeaves);
        structure.addBlock(-6,1,0, palmLeaves);

        structure.addBlock(-7,0,0, palmLeaves);

        // Side Leaves Z+
        structure.addBlock(-1,1,2, palmLeaves);
        structure.addBlock(-1,1,3, palmLeaves);
        structure.addBlock(-1,1,4, palmLeaves);
        structure.addBlock(-1,1,5, palmLeaves);
        structure.addBlock(1,1,2, palmLeaves);
        structure.addBlock(1,1,3, palmLeaves);
        structure.addBlock(1,1,4, palmLeaves);
        structure.addBlock(1,1,5, palmLeaves);

        structure.addBlock(0,2,2, palmLeaves);
        structure.addBlock(0,2,3, palmLeaves);
        structure.addBlock(0,2,4, palmLeaves);
        structure.addBlock(0,2,5, palmLeaves);

        structure.addBlock(-1,0,6, palmLeaves);
        structure.addBlock(1,0,6, palmLeaves);
        structure.addBlock(0,1,6, palmLeaves);

        structure.addBlock(0,0,7, palmLeaves);

        // Side Leaves Z-
        structure.addBlock(-1,1,-2, palmLeaves);
        structure.addBlock(-1,1,-3, palmLeaves);
        structure.addBlock(-1,1,-4, palmLeaves);
        structure.addBlock(-1,1,-5, palmLeaves);
        structure.addBlock(1,1,-2, palmLeaves);
        structure.addBlock(1,1,-3, palmLeaves);
        structure.addBlock(1,1,-4, palmLeaves);
        structure.addBlock(1,1,-5, palmLeaves);

        structure.addBlock(0,2,-2, palmLeaves);
        structure.addBlock(0,2,-3, palmLeaves);
        structure.addBlock(0,2,-4, palmLeaves);
        structure.addBlock(0,2,-5, palmLeaves);

        structure.addBlock(-1,0,-6, palmLeaves);
        structure.addBlock(1,0,-6, palmLeaves);
        structure.addBlock(0,1,-6, palmLeaves);

        structure.addBlock(0,0,-7, palmLeaves);

        // Corner Leaves X+ Z+
        structure.addBlock(2,2,2, palmLeaves);
        structure.addBlock(3,2,3, palmLeaves);
        structure.addBlock(4,2,4, palmLeaves);

        structure.addBlock(3,1,2, palmLeaves);
        structure.addBlock(4,1,3, palmLeaves);
        structure.addBlock(5,1,4, palmLeaves);

        structure.addBlock(2,1,3, palmLeaves);
        structure.addBlock(3,1,4, palmLeaves);
        structure.addBlock(4,1,5, palmLeaves);

        structure.addBlock(5,0,5, palmLeaves);

        // Corner Leaves X- Z+
        structure.addBlock(-2,2,2, palmLeaves);
        structure.addBlock(-3,2,3, palmLeaves);
        structure.addBlock(-4,2,4, palmLeaves);

        structure.addBlock(-3,1,2, palmLeaves);
        structure.addBlock(-4,1,3, palmLeaves);
        structure.addBlock(-5,1,4, palmLeaves);

        structure.addBlock(-2,1,3, palmLeaves);
        structure.addBlock(-3,1,4, palmLeaves);
        structure.addBlock(-4,1,5, palmLeaves);

        structure.addBlock(-5,0,5, palmLeaves);

        // Corner Leaves X+ Z-
        structure.addBlock(2,2,-2, palmLeaves);
        structure.addBlock(3,2,-3, palmLeaves);
        structure.addBlock(4,2,-4, palmLeaves);

        structure.addBlock(3,1,-2, palmLeaves);
        structure.addBlock(4,1,-3, palmLeaves);
        structure.addBlock(5,1,-4, palmLeaves);

        structure.addBlock(2,1,-3, palmLeaves);
        structure.addBlock(3,1,-4, palmLeaves);
        structure.addBlock(4,1,-5, palmLeaves);

        structure.addBlock(5,0,-5, palmLeaves);

        // Corner Leaves X- Z-
        structure.addBlock(-2,2,-2, palmLeaves);
        structure.addBlock(-3,2,-3, palmLeaves);
        structure.addBlock(-4,2,-4, palmLeaves);

        structure.addBlock(-3,1,-2, palmLeaves);
        structure.addBlock(-4,1,-3, palmLeaves);
        structure.addBlock(-5,1,-4, palmLeaves);

        structure.addBlock(-2,1,-3, palmLeaves);
        structure.addBlock(-3,1,-4, palmLeaves);
        structure.addBlock(-4,1,-5, palmLeaves);

        structure.addBlock(-5,0,-5, palmLeaves);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            return structure.generate(world, x, y, z, random.nextInt(7, 12));
        }
        return false;
    }
}
