package net.danygames2014.tropicraft.mixin.achievements;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.achievement.TropicraftAchievements;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {
    @Shadow public ItemStack stack;

    public ItemEntityMixin(World world) {
        super(world);
    }

    @Inject(method = "onPlayerInteraction", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/Entity;Ljava/lang/String;FF)V", shift = At.Shift.BEFORE))
    public void grantAchievementOnPickup(PlayerEntity player, CallbackInfo ci){
        if(this.stack.itemId == Tropicraft.bambooShootItem.id){
            player.incrementStat(TropicraftAchievements.BAMBOOZLED);
        }

        if(this.stack.itemId == Tropicraft.solonoxShell.id){
            player.incrementStat(TropicraftAchievements.STEAMED_CLAMS);
        }
    }
}
