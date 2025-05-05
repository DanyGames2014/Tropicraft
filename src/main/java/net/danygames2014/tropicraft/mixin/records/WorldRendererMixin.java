package net.danygames2014.tropicraft.mixin.records;

import net.danygames2014.tropicraft.item.TropiRecordItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow private Minecraft client;

    @Unique
    public void tropicraft_playStreaming(String stream, int x, int y, int z, String jukeboxMessage) {
        if (stream != null) {
            this.client.inGameHud.setRecordPlayingOverlay(jukeboxMessage);
        }

        this.client.soundManager.playStreaming(stream, (float)x, (float)y, (float)z, 1.0F, 1.0F);
    }

    @Inject(
            method = {"worldEvent"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;playStreaming(Ljava/lang/String;III)V",
                    ordinal = 0
            ),
            cancellable = true
    )
    public void worldEvent(PlayerEntity player, int event, int x, int y, int z, int data, CallbackInfo ci) {
        if (Item.ITEMS[data] instanceof TropiRecordItem) {
            tropicraft_playStreaming(((TropiRecordItem) Item.ITEMS[data]).sound, x, y, z, ((TropiRecordItem) Item.ITEMS[data]).jukeboxMessage);
            ci.cancel();
        }
    }
}
