package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CoconutBlock extends TemplateBlock {
    public CoconutBlock(Identifier identifier, Material material) {
        super(identifier, material);
        this.setBoundingBox(0.25F,0.15F,0.25F,0.75F, 0.775F,0.75F);
    }

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        if((player.inventory.getSelectedItem() != null) && (player.inventory.getSelectedItem().getItem() instanceof SwordItem)){
            this.dropStacks(world,x,y,z, 1);
            world.setBlock(x,y,z,0);
        }
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return blockMeta == 1 ? Item.DYE.id : Tropicraft.coconut.id;
    }

    @Override
    protected int getDroppedItemMeta(int blockMeta) {
        return 0;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
