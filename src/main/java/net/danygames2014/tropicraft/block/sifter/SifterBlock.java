package net.danygames2014.tropicraft.block.sifter;

import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

public class SifterBlock extends TemplateBlockWithEntity {
    public SifterBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new SifterBlockEntity();
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        SifterBlockEntity blockEntity = ((SifterBlockEntity)world.getBlockEntity(x,y,z));

        if(blockEntity.sift(player.getHand())){
            player.getHand().count--;
            return true;
        }
        return false;
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
