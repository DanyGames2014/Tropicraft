package net.danygames2014.tropicraft.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateMusicDiscItem;
import net.modificationstation.stationapi.api.util.Identifier;

@SuppressWarnings("deprecation")
public class TropiRecordItem extends TemplateMusicDiscItem {
    public String jukeboxMessage;

    public TropiRecordItem(Identifier identifier, String sound, String jukeboxMessage) {
        super(identifier, sound);
        this.jukeboxMessage = jukeboxMessage;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        boolean result = super.useOnBlock(stack, user, world, x, y, z, side);
        if(world.getBlockState(x,y,z).isOf(Block.JUKEBOX)){
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).inGameHud.setRecordPlayingOverlay(jukeboxMessage);
        }
        return result;
    }
}
