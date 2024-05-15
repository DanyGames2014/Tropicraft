package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CoconutBlock extends TemplateBlock {
    public static boolean chopped;

    public CoconutBlock(Identifier identifier, Material material) {
        super(identifier, material);
        this.setBoundingBox(0.25F, 0.15F, 0.25F, 0.75F, 0.85F, 0.75F);
        chopped = false;
    }

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        if ((player.inventory.getSelectedItem() != null) && (player.inventory.getSelectedItem().getItem() instanceof SwordItem)) {
            chop(world, x, y, z);
        }
    }

    public void chop(World world, int x, int y, int z) {
        chopped = true;
        this.dropStacks(world, x, y, z, 1);
        world.setBlock(x, y, z, 0);
        chopped = false;
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return chopped ? Tropicraft.coconutChunk.id : Tropicraft.coconut.id;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        if (chopped) {
            if (random.nextInt(7) == 0) {
                return 1;
            }
            if (random.nextInt(6) == 0) {
                return 2;
            }
            if (random.nextInt(5) == 0) {
                return 3;
            }
            return random.nextInt(4) == 0 ? 4 : 5;
        }
        return 1;
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
