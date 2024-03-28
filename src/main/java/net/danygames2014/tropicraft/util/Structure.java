package net.danygames2014.tropicraft.util;

import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Structure {
    public ArrayList<StructureBlockEntry> blocks;

    public Structure() {
        this.blocks = new ArrayList<>();
    }

    // Checks if there are conflicting blocks which have the CollisionType.DONT_GENERATE type
    // Returns true if collision was found
    public boolean checkCollision(World world, int x, int y, int z) {
        for (var block : this.blocks) {
            // If block isn't air and collision type is DONT_GENERATE, return true
            if ((world.getBlockId(x + block.xOffset, y + block.yOffset, z + block.zOffset) != 0) && block.collisionType == CollisionType.DONT_GENERATE) {
                return true;
            }
        }
        return false;
    }

    // Returns true if generation was succesfull
    public boolean generate(World world, int x, int y, int z) {
        if (this.checkCollision(world, x, y, z)) {
            return false;
        }
        for (var block : this.blocks) {
            if (world.getBlockId(x + block.xOffset, y + block.yOffset, z + block.zOffset) == 0) {
                world.setBlock(x + block.xOffset, y + block.yOffset, z + block.zOffset, BlockRegistry.INSTANCE.get(block.blockId).id);
            } else {
                switch (block.collisionType) {
                    case DONT_GENERATE -> {
                        return false;
                    }
                    case REPLACE_BLOCK -> {
                        world.setBlock(x + block.xOffset, y + block.yOffset, z + block.zOffset, BlockRegistry.INSTANCE.get(block.blockId).id);
                    }
                    case DONT_PLACE -> {

                    }
                }
            }
        }
        return true;
    }

    public void addBlock(int xOffset, int yOffset, int zOffset, Identifier blockId) {
        addBlock(xOffset, yOffset, zOffset, blockId, CollisionType.DONT_PLACE);
    }

    public void addBlock(int xOffset, int yOffset, int zOffset, Identifier blockId, CollisionType collisionType) {
        blocks.add(new StructureBlockEntry((byte) xOffset, (byte) yOffset, (byte) zOffset, blockId, collisionType));
    }

    public static class StructureBlockEntry {
        public byte xOffset;
        public byte yOffset;
        public byte zOffset;
        public Identifier blockId;
        public CollisionType collisionType;

        public StructureBlockEntry(byte xOffset, byte yOffset, byte zOffset, Identifier blockId, CollisionType collisionType) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            this.zOffset = zOffset;
            this.blockId = blockId;
            this.collisionType = collisionType;
        }
    }

    public enum CollisionType {
        // This will prevent the entire structure from generating at all
        DONT_GENERATE,

        // This will prevent placing the conflicting block
        DONT_PLACE,

        // This will replace the existing block with the structure one
        REPLACE_BLOCK
    }
}
