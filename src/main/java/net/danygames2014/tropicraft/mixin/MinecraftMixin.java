package net.danygames2014.tropicraft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldStorageSource;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    private WorldStorageSource worldStorageSource;

    @Inject(method = "setWorld(Lnet/minecraft/world/World;Ljava/lang/String;Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;player:Lnet/minecraft/entity/player/ClientPlayerEntity;", ordinal = 2, opcode = Opcodes.PUTFIELD, shift = At.Shift.AFTER))
    public void nORTCH(World message, String player, PlayerEntity par3, CallbackInfo ci) {
        this.worldStorageSource.flush();
    }
}
