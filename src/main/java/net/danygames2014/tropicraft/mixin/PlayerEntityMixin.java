package net.danygames2014.tropicraft.mixin;

import net.danygames2014.tropicraft.item.EntityInteractor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Shadow
    public abstract ItemStack getHand();

    public PlayerEntityMixin(World world) {
        super(world);
    }

    @Inject(method = "interact", at = @At(value = "HEAD"), cancellable = true)
    public void interactWithEntity(Entity entity, CallbackInfo ci) {
        ItemStack stack = this.getHand();
        if (stack != null && stack.getItem() instanceof EntityInteractor interactor) {
            interactor.interactWithEntity(stack, entity, PlayerEntity.class.cast(this));
            ci.cancel();
        }
    }

    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    public void attackEntity(Entity entity, CallbackInfo ci) {
        ItemStack stack = this.getHand();
        if (stack != null && stack.getItem() instanceof EntityInteractor interactor) {
            if (!interactor.attackEntity(stack, entity, PlayerEntity.class.cast(this))) {
                ci.cancel();
            }
        }
    }
}
