package net.danygames2014.tropicraft.util;

public enum RenderType {
    BLOCK(0),
    FLUID(4),
    CACTUS(13),
    CROSS(1),
    CROP(6),
    TORCH(2),
    FIRE(3),
    REDSTONE_DUST(5),
    LADDER(8),
    DOOR(7),
    RAIL(9),
    STAIRS(10),
    FENCE(11),
    LEVER(12),
    BED(14),
    REPEATER(15),
    PISTON(16),
    PISTON_HEAD(17);

    public int renderType;

    RenderType(int renderType) {
        this.renderType = renderType;
    }
}
