package net.danygames2014.tropicraft.world.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;

import java.util.ArrayList;

public class Structure {
    public ArrayList<StructureBlockEntry> blocks;

    public Structure() {
        this.blocks = new ArrayList<>();
    }

    /*
        Add Block Methods
    */

    public boolean addBlock(StructureBlockEntry entry) {
        return this.blocks.add(entry);
    }

    public boolean addBlock(byte xOffset, byte yOffset, byte zOffset, BlockState state, CollisionType collisionType) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, state, collisionType));
    }

    public boolean addBlock(byte xOffset, byte yOffset, byte zOffset, BlockState state) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, state));
    }

    public boolean addBlock(byte xOffset, byte yOffset, byte zOffset, Block block, CollisionType collisionType) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, block, collisionType));
    }

    public boolean addBlock(byte xOffset, byte yOffset, byte zOffset, Block block) {
        return this.addBlock(new StructureBlockEntry(xOffset, yOffset, zOffset, block));
    }

    /**
     * Checks if the block would prevent the structure from generating
     *
     * @param world The world the structure is in
     * @param x     The X coordinate of the structure
     * @param y     The Y coordinate of the structure
     * @param z     The Z coordinate of the structure
     * @param block The block to check
     * @return True if the the block would prevent the structure from generatin
     */
//    public boolean checkBlockCollision(World world, int x, int y, int z, StructureBlockEntry block) {
//        return !(isReplaceable(world, x, y, z)) && (block.collisionType == CollisionType.DONT_GENERATE);
//    }

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

    public boolean generate(World world, int x, int y, int z){
        var startTime = System.nanoTime();

        if(!checkCollision(world, x, y, z)){
            return false;
        }

        for (StructureBlockEntry block : this.blocks) {
        }

        System.out.println(this.getClass().getCanonicalName() + " GENERATION TOOK " + (System.nanoTime() - startTime) / 1000 + "uS");
        return true;
    }

    public boolean placeBlock(World world, StructureBlockEntry block) {
        //if()
        return false;
    }

    // Helper method to see if material is either air or replaceable
    public boolean isReplaceable(World world, int x, int y, int z) {
        return world.getBlockState(x, y, z).isAir() || world.getMaterial(x, y, z).isReplaceable();
    }
}
