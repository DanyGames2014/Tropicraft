package net.danygames2014.tropicraft.block.sifter;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class SifterBlockEntityRenderer extends BlockEntityRenderer {
    @SuppressWarnings("deprecation")
    private static final Minecraft minecraft = (Minecraft) FabricLoader.getInstance().getGameInstance();

    @Override
    public void render(BlockEntity blockEntity, double x, double y, double z, float rotation) {
        SifterBlockEntity sifter = (SifterBlockEntity)blockEntity;

        if(sifter.siftTimeRemaining >= 0 && sifter.siftedItem != null){
            PlayerEntity player = minecraft.player;

            if(sifter.renderedItem == null){
                sifter.renderedItem = new ItemEntity(player.world);
                sifter.renderedItem.setPos(player.x, player.y, player.z);
                sifter.renderedItem.stack = sifter.siftedItem;
            }

            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5F, (float)y+0.3F, (float)z + 0.5F);
            GL11.glRotatef((float)(sifter.yaw2 + (sifter.yaw - sifter.yaw2) * (double)rotation) * 10.0F, 0.0F, 1.0F, 0.0F);
            EntityRenderDispatcher.field_2489.method_1920(sifter.renderedItem, 0.0, 0.0, 0.0, 0.0F, 0.0F);
            GL11.glPopMatrix();
        }
    }
}
