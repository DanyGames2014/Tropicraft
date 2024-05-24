package net.danygames2014.tropicraft.world.structure;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.block.BlockState;

public class StructureBlockEntry {
    public byte xOffset;
    public byte yOffset;
    public byte zOffset;
    public BlockState state;
    CollisionType collisionType;

    // Default Constructor
    public StructureBlockEntry(byte xOffset, byte yOffset, byte zOffset, BlockState state, CollisionType collisionType) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
        this.state = state;
        this.collisionType = collisionType;
    }

    // Default Constructor with Default Collision Type
    public StructureBlockEntry(byte xOffset, byte yOffset, byte zOffset, BlockState state) {
        this(xOffset, yOffset, zOffset, state, CollisionType.DONT_PLACE);
    }

    // Block Constructor
    public StructureBlockEntry(byte xOffset, byte yOffset, byte zOffset, Block block, CollisionType collisionType) {
        this(xOffset, yOffset, zOffset, block.getDefaultState(), collisionType);
    }

    // Block Constructor with Defautl Collision Type
    public StructureBlockEntry(byte xOffset, byte yOffset, byte zOffset, Block block) {
        this(xOffset, yOffset, zOffset, block.getDefaultState(), CollisionType.DONT_PLACE);
    }

    public BlockState getState(){
        return state;
    }
}
