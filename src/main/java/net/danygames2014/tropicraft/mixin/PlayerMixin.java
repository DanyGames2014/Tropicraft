package net.danygames2014.tropicraft.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class PlayerMixin extends LivingEntity {
    public PlayerMixin(World arg) {
        super(arg);
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void aaa(CallbackInfo ci){
        System.out.println(this.jumping);
    }
}
