package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BambooShootBlock extends TemplateBlock {

    public BambooShootBlock(Identifier identifier) {
        super(identifier, Material.field_988);
        float f = 0.375f;
        this.setBoundingBox(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
        this.setTickRandomly(true);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.method_234(x, y + 1, z)) {
            int l = 1;
            while (world.getBlockId(x, y - l, z) == this.id) {
                ++l;
            }
            if (l < 10) {
                int i1 = world.getBlockMeta(x, y, z);
                if (i1 == 8) {
                    world.setBlock(x, y + 1, z, this.id);
                    world.method_215(x, y, z, 0);
                } else {
                    world.method_215(x, y, z, i1 + 1);
                }
            }
        }
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int blockIdBelow = world.getBlockId(x, y - 1, z);
        if (blockIdBelow == this.id) {
            return true;
        }
        if (blockIdBelow != Block.GRASS_BLOCK.id && blockIdBelow != Block.DIRT.id) {
            return false;
        }
        if (world.getBlockId(x - 1, y - 1, z) == Block.DIRT.id || world.getBlockId(x - 1, y - 1, z) == Block.GRASS_BLOCK.id) {
            return true;
        }
        if (world.getBlockId(x + 1, y - 1, z) == Block.DIRT.id || world.getBlockId(x + 1, y - 1, z) == Block.GRASS_BLOCK.id) {
            return true;
        }
        if (world.getBlockId(x, y - 1, z - 1) == Block.DIRT.id || world.getBlockId(x, y - 1, z - 1) == Block.GRASS_BLOCK.id) {
            return true;
        }
        return world.getBlockId(x, y - 1, z + 1) == Block.GRASS.id;
    }

    @Override
    public void neighborUpdate(World world, int i, int j, int k, int l) {
        this.checkBlockCoordValid(world, i, j, k);
    }

    protected final void checkBlockCoordValid(World world, int x, int y, int z) {
        if (!this.canGrow(world, x, y, z)) {
            this.dropStack(world,x,y,z, new ItemStack(this.getDroppedItemId(0, null), 1, 0));
            world.setBlock(x, y, z, 0);
        }
    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        return this.canPlaceAt(world, x, y, z);
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return Tropicraft.bambooShootItem.id;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    //    @Override
//    public int getRenderType() {
//        return RenderType.CROSS.renderType;
//    }
}