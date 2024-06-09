package net.danygames2014.tropicraft.world.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings({"UnusedReturnValue", "BooleanMethodIsAlwaysInverted"})
public class Structure {
    public ArrayList<StructureBlockEntry> blocks;
    public Random random;

    public Structure(World world) {
        this.blocks = new ArrayList<>();
        this.random = world.field_214;
    }

    /*
        Add Block Methods
    */

    public boolean addBlock(StructureBlockEntry entry) {
        return this.blocks.add(entry);
    }

    public boolean addBlock(int xOffset, int yOffset, int zOffset, BlockState state, CollisionType collisionType) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, state, collisionType));
    }

    public boolean addBlock(int xOffset, int yOffset, int zOffset, BlockState state) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, state));
    }

    public boolean addBlock(int xOffset, int yOffset, int zOffset, Block block, CollisionType collisionType) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, block, collisionType));
    }

    public boolean addBlock(int xOffset, int yOffset, int zOffset, Block block) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, block));
    }

    /**
     * Checks if the structure can be generated according to its Collision Type rules
     *
     * @param world The world the structure is in
     * @param x     The X coordinate of the structure
     * @param y     The Y coordinate of the structure
     * @param z     The Z coordinate of the structure
     * @return True if the structure can be placed
     */
    public boolean checkCollision(World world, int x, int y, int z) {
        for (StructureBlockEntry block : this.blocks) {
            if (!isReplaceable(world, x + block.xOffset, y + block.yOffset, z + block.zOffset) && (block.collisionType == CollisionType.DONT_GENERATE)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generate the structure
     *
     * @param world The world to generate it in
     * @param x     The X coordinate of the structure
     * @param y     The Y coordinate of the structure
     * @param z     The Z coordinate of the structure
     * @return Returns true if the structure was placed succesfully
     */
    public boolean generate(World world, int x, int y, int z) {
        var startTime = System.nanoTime();

        if (!checkCollision(world, x, y, z)) {
            return false;
        }

        for (StructureBlockEntry block : this.blocks) {
            placeBlock(world, x, y, z, block);
        }

        System.out.println(this.getClass().getCanonicalName() + " GENERATION TOOK " + (System.nanoTime() - startTime) / 1000 + "uS");
        return true;
    }

    /**
     * @param world The world the to place the block in
     * @param x     The X coordinate of the structure
     * @param y     The Y coordinate of the structure
     * @param z     The Z coordinate of the structure
     * @param block The block to place
     * @return true if the block placement was succesfull
     */
    public boolean placeBlock(World world, int x, int y, int z, StructureBlockEntry block) {
        if (!isReplaceable(world, x + block.xOffset, y + block.yOffset, z + block.zOffset)) {
            if (block.collisionType == CollisionType.REPLACE_BLOCK) {
                world.setBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset, block.getState(this, world, x, y, z, block));
                return true;
            } else {
                return false;
            }
        } else {
            world.setBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset, block.getState(this, world, x, y, z, block));
            return true;
        }
    }

    // Helper method to see if material is either air or replaceable
    private boolean isReplaceable(World world, int x, int y, int z) {
        return world.getBlockState(x, y, z).isAir() || world.getMaterial(x, y, z).isReplaceable();
    }
}
