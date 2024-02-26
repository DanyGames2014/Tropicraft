package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.texture.TextureHelper;
import net.modificationstation.stationapi.api.template.block.TemplateStairsBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BambooStairs extends TemplateStairsBlock {
    public BambooStairs(Identifier identifier, Block arg) {
        super(identifier, arg);
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return this.id;
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int l, float f) {
        if(!world.isRemote){
            this.dropStack(world, x, y, z, new ItemStack(this.id, 1, 0));
        }
    }

    @Override
    public int getTexture(int side) {
        return Tropicraft.bambooPlanksBlock.textureId;
    }
}
