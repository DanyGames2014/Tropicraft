package net.danygames2014.tropicraft.world.feature;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.util.Structure;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class PalmTreeFeature extends Feature {

    Structure palmTreeStructure;

    public PalmTreeFeature() {
        this.palmTreeStructure = new Structure();

        Identifier palmLogId = Tropicraft.NAMESPACE.id("palm_log");
        palmTreeStructure.addBlock(0, 0, 0, palmLogId);
        palmTreeStructure.addBlock(0, 1, 0, palmLogId);
        palmTreeStructure.addBlock(0, 2, 0, palmLogId);
        palmTreeStructure.addBlock(0, 3, 0, palmLogId);
        palmTreeStructure.addBlock(0, 4, 0, palmLogId);
        palmTreeStructure.addBlock(0, 5, 0, palmLogId);
        palmTreeStructure.addBlock(0, 6, 0, palmLogId);
        palmTreeStructure.addBlock(0, 7, 0, palmLogId);
        palmTreeStructure.addBlock(0, 8, 0, palmLogId);
        palmTreeStructure.addBlock(1, 8, 0, palmLogId);
        palmTreeStructure.addBlock(-1, 8, 0, palmLogId);
        palmTreeStructure.addBlock(0, 8, 1, palmLogId);
        palmTreeStructure.addBlock(0, 8, -1, palmLogId);

    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        y = world.getTopY(x, z);
        if (world.getBlockId(x, y - 1, z) == Block.SAND.id) {
            return palmTreeStructure.generate(world, x, y, z);
        }
        return false;
    }
}
