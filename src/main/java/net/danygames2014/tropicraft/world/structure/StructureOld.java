package net.danygames2014.tropicraft.world.structure;

import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.ArrayList;

@Deprecated
@SuppressWarnings("ALL")
public class StructureOld {
    public ArrayList<StructureBlockEntryOld> blocks;

    public StructureOld() {
        this.blocks = new ArrayList<>();
    }

    // Checks if there are conflicting blocks which have the CollisionType.DONT_GENERATE type
    // Returns true if collision was found
    public boolean checkCollision(World world, int x, int y, int z) {
        for (var block : this.blocks) {
            // If block isn't air and collision type is DONT_GENERATE, return true
            if (!world.getBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset).isAir() && block.collisionType == CollisionTypeOld.DONT_GENERATE) {
                return true;
            }
        }
        return false;
    }

    // Returns true if generation was succesfull
    public boolean generate(World world, int x, int y, int z) {
        var startTime = System.nanoTime();
        if (this.checkCollision(world, x, y, z)) {
            return false;
        }
        for (var block : this.blocks) {
            if (world.getBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset).isAir()) {
                world.setBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset, BlockRegistry.INSTANCE.get(block.blockId).getDefaultState());
            } else {
                switch (block.collisionType) {
                    case DONT_GENERATE -> {
                        return false;
                    }
                    case REPLACE_BLOCK -> {
                        world.setBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset, BlockRegistry.INSTANCE.get(block.blockId).getDefaultState());
                    }
                    case DONT_PLACE -> {

                    }
                }
            }
        }
        System.out.println(this.getClass().getCanonicalName() + " GENERATION TOOK " + (System.nanoTime() - startTime) / 1000 + "uS");
        return true;
    }

    public void addBlock(int xOffset, int yOffset, int zOffset, Identifier blockId) {
        addBlock(xOffset, yOffset, zOffset, blockId, CollisionTypeOld.DONT_PLACE);
    }

    public void addBlock(int xOffset, int yOffset, int zOffset, Identifier blockId, CollisionTypeOld collisionType) {
        blocks.add(new StructureBlockEntryOld((byte) xOffset, (byte) yOffset, (byte) zOffset, blockId, collisionType));
    }

    public static class StructureBlockEntryOld {
        public byte xOffset;
        public byte yOffset;
        public byte zOffset;
        public Identifier blockId;
        public CollisionTypeOld collisionType;

        public StructureBlockEntryOld(byte xOffset, byte yOffset, byte zOffset, Identifier blockId, CollisionTypeOld collisionType) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            this.zOffset = zOffset;
            this.blockId = blockId;
            this.collisionType = collisionType;
        }
    }

    public enum CollisionTypeOld {
        // This will prevent the entire structure from generating at all
        DONT_GENERATE,

        // This will prevent placing the conflicting block
        DONT_PLACE,

        // This will replace the existing block with the structure one
        REPLACE_BLOCK
    }
}