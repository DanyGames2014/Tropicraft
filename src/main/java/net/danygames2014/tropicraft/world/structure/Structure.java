package net.danygames2014.tropicraft.world.structure;

import net.minecraft.world.World;

import java.util.ArrayList;

public class Structure {
    public ArrayList<StructureBlockEntry> blocks;

    public Structure() {
        this.blocks = new ArrayList<>();
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
    public boolean checkBlockCollision(World world, int x, int y, int z, StructureBlockEntry block) {
        return !(world.getBlockState(x + block.xOffset, y + block.yOffset, z + block.zOffset).isAir()) && block.collisionType == CollisionType.DONT_GENERATE;
    }

    public boolean checkCollision(World world, int x, int y, int z) {
        return false;
    }

    public boolean generate(World world, int x, int y, int z) {
        return false;
    }
}
