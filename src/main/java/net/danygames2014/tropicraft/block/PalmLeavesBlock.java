package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class PalmLeavesBlock extends TemplateBlock {
    public PalmLeavesBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, int x, int y, int z, int meta) {
        if (player.getHand() != null && player.getHand().getItem() instanceof ShearsItem) {
            this.dropStack(world, x, y, z, new ItemStack(Tropicraft.palmLeaves, 1));
            player.increaseStat(Stats.MINE_BLOCK[this.id], 1);
            return;
        }

        if (world.field_214.nextInt(20) == 0) {
            this.dropStack(world, x, y, z, new ItemStack(Tropicraft.palmSapling, 1));
        }
    }
}
