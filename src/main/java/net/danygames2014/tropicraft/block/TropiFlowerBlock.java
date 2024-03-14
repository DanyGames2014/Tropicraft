package net.danygames2014.tropicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class TropiFlowerBlock extends TemplateBlock {
    public TropiFlowerBlock(Identifier identifier) {
        super(identifier, Material.field_988);
        float f = 0.2f;
        this.setBoundingBox(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 4.939f, 0.5f + f);
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int blockIdBelow = world.getBlockId(x, y - 1, z);
        return super.canPlaceAt(world, x, y, z) && (blockIdBelow == Block.GRASS_BLOCK.id || blockIdBelow == Block.DIRT.id || blockIdBelow == Block.FARMLAND.id);
    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        return canPlaceAt(world, x, y, z);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }
}
