package net.danygames2014.tropicraft.util;

import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

@SuppressWarnings("DataFlowIssue")
public class TreeStructure extends Structure {
    public Identifier trunkBlockId;
    public CollisionType trunkCollisionType;

    public TreeStructure(Identifier trunkBlockId, CollisionType trunkCollisionType) {
        this.trunkBlockId = trunkBlockId;
        this.trunkCollisionType = trunkCollisionType;
    }

    // Checks if there are conflicting blocks which have the CollisionType.DONT_GENERATE type
    // Returns true if collision was found
    public boolean checkCollision(World world, int x, int y, int z, int trunkHeight) {
        for (int i = 0; i < trunkHeight; i++) {
            if ((world.getBlockId(x, y + i, z) != 0) && trunkCollisionType == CollisionType.DONT_GENERATE) {
                return true;
            }
        }
        return super.checkCollision(world, x, y + trunkHeight, z);
    }

    // Returns true if generation was succesfull
    public boolean generate(World world, int x, int y, int z, int trunkHeight) {
        if (this.checkCollision(world, x, y, z, trunkHeight)) {
            return false;
        }

        for (int i = 0; i < trunkHeight; i++) {
            if (world.getBlockId(x, y + i, z) == 0) {
                world.setBlock(x, y + i, z, BlockRegistry.INSTANCE.get(trunkBlockId).id);
            } else {
                switch (trunkCollisionType) {
                    case DONT_GENERATE -> {
                        return false;
                    }
                    case REPLACE_BLOCK -> {
                        world.setBlock(x, y + i, z, BlockRegistry.INSTANCE.get(trunkBlockId).id);
                    }
                    case DONT_PLACE -> {

                    }
                }
            }
        }
        return super.generate(world, x, y + trunkHeight, z);
    }
}
