package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.structure.Rotation;
import net.danygames2014.tropicraft.world.structure.Structure;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import java.util.Random;

public class CurvedPalmTreeFeature extends Feature {
    Structure structure;

    public CurvedPalmTreeFeature(World world) {
        BlockState palmLog = Tropicraft.palmLog.getDefaultState();
        BlockState palmLeaves = Tropicraft.palmLeaves.getDefaultState();

        this.structure = new Structure(world);

        // Trunk
        structure.addBlock(0, 0, 0, palmLog);
        structure.addBlock(1, 0, 0, palmLog);
        structure.addBlock(1, 1, 0, palmLog);
        structure.addBlock(2, 1, 0, palmLog);
        structure.addBlock(2, 2, 0, palmLog);
        structure.addBlock(2, 3, 0, palmLog);
        structure.addBlock(3, 3, 0, palmLog);
        structure.addBlock(3, 4, 0, palmLog);
        structure.addBlock(3, 5, 0, palmLog);
        structure.addBlock(3, 6, 0, palmLog);
        structure.addBlock(3, 7, 0, palmLog);
        structure.addBlock(3, 8, 0, palmLog);

        // Leaves Core
        structure.addBlock(4, 8, 0, palmLeaves);
        structure.addBlock(2, 8, 0, palmLeaves);
        structure.addBlock(3, 8, -1, palmLeaves);
        structure.addBlock(3, 8, 1, palmLeaves);

        // Top Stalk
        structure.addBlock(3, 9, 0, palmLeaves);
        structure.addBlock(3, 10, 0, palmLeaves);
        structure.addBlock(3, 11, 0, palmLeaves);
        structure.addBlock(4, 12, 0, palmLeaves);

        // Small Side Leaves
        structure.addBlock(5, 8, 0, palmLeaves);
        structure.addBlock(6, 8, 0, palmLeaves);
        structure.addBlock(7, 7, 0, palmLeaves);

        structure.addBlock(1, 8, 0, palmLeaves);
        structure.addBlock(0, 8, 0, palmLeaves);
        structure.addBlock(-1, 7, 0, palmLeaves);

        structure.addBlock(3, 8, -2, palmLeaves);
        structure.addBlock(3, 8, -3, palmLeaves);
        structure.addBlock(3, 7, -4, palmLeaves);

        structure.addBlock(3, 8, 2, palmLeaves);
        structure.addBlock(3, 8, 3, palmLeaves);
        structure.addBlock(3, 7, 4, palmLeaves);

        // Top Corner Leaves
        structure.addBlock(4, 9, -1, palmLeaves);
        structure.addBlock(4, 10, -2, palmLeaves);
        structure.addBlock(5, 10, -1, palmLeaves);
        structure.addBlock(5, 11, -2, palmLeaves);

        structure.addBlock(4, 9, 1, palmLeaves);
        structure.addBlock(4, 10, 2, palmLeaves);
        structure.addBlock(5, 10, 1, palmLeaves);
        structure.addBlock(5, 11, 2, palmLeaves);

        structure.addBlock(2, 9, -1, palmLeaves);
        structure.addBlock(2, 10, -2, palmLeaves);
        structure.addBlock(1, 10, -1, palmLeaves);
        structure.addBlock(1, 11, -2, palmLeaves);

        structure.addBlock(2, 9, 1, palmLeaves);
        structure.addBlock(2, 10, 2, palmLeaves);
        structure.addBlock(1, 10, 1, palmLeaves);
        structure.addBlock(1, 11, 2, palmLeaves);

        // Bottom Corner Leaves
        structure.addBlock(4, 7, -1, palmLeaves);
        structure.addBlock(4, 6, -2, palmLeaves);
        structure.addBlock(5, 6, -1, palmLeaves);
        structure.addBlock(5, 5, -2, palmLeaves);

        structure.addBlock(4, 7, 1, palmLeaves);
        structure.addBlock(4, 6, 2, palmLeaves);
        structure.addBlock(5, 6, 1, palmLeaves);
        structure.addBlock(5, 5, 2, palmLeaves);

        structure.addBlock(2, 7, -1, palmLeaves);
        structure.addBlock(2, 6, -2, palmLeaves);
        structure.addBlock(1, 6, -1, palmLeaves);
        structure.addBlock(1, 5, -2, palmLeaves);

        structure.addBlock(2, 7, 1, palmLeaves);
        structure.addBlock(2, 6, 2, palmLeaves);
        structure.addBlock(1, 6, 1, palmLeaves);
        structure.addBlock(1, 5, 2, palmLeaves);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            return structure.generate(world, x, y, z, Rotation.getRotation(random.nextInt(0, 4)));
        }
        return false;
    }
}
