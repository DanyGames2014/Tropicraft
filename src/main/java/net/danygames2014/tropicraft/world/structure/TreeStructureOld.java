package net.danygames2014.tropicraft.world.structure;

import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

@Deprecated
@SuppressWarnings("DataFlowIssue")
public class TreeStructureOld extends StructureOld {
    public Identifier trunkBlockId;
    private final BlockState trunkBlockState;
    public CollisionTypeOld trunkCollisionType;

    public TreeStructureOld(Identifier trunkBlockId, CollisionTypeOld trunkCollisionType) {
        this.trunkBlockId = trunkBlockId;
        this.trunkBlockState = BlockRegistry.INSTANCE.get(trunkBlockId).getDefaultState();
        this.trunkCollisionType = trunkCollisionType;
    }

    // Checks if there are conflicting blocks which have the CollisionType.DONT_GENERATE type
    // Returns true if collision was found
    public boolean checkCollision(World world, int x, int y, int z, int trunkHeight) {
        for (int i = 0; i < trunkHeight; i++) {
            if (!world.getBlockState  (x,y+i, z).isAir() && trunkCollisionType == CollisionTypeOld.DONT_GENERATE) {
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
            if (world.getBlockState(x, y + i, z).isAir()) {
                world.setBlockState(x, y + i, z, trunkBlockState);
            } else {
                switch (trunkCollisionType) {
                    case DONT_GENERATE -> {
                        return false;
                    }
                    case REPLACE_BLOCK -> {
                        world.setBlockState(x, y + i, z, trunkBlockState);
                    }
                    case DONT_PLACE -> {

                    }
                }
            }
        }
        return super.generate(world, x, y + trunkHeight, z);
    }
}
