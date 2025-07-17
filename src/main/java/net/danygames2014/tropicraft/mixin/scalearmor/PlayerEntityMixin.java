package net.danygames2014.tropicraft.mixin.scalearmor;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin extends LivingEntityMixin {
    @Shadow
    public PlayerInventory inventory;

    @Unique
    public boolean wearingScaleArmorSet;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void scaleArmorFireImmune(CallbackInfo ci) {
        // If the player is already fire immune we do not need to carry out this expensive check
        if (this.fireImmune) {
            return;
        }

        if (inventory.armor[0] == null || inventory.armor[1] == null || inventory.armor[2] == null || inventory.armor[3] == null) {
            this.wearingScaleArmorSet = false;
        } else {
            this.wearingScaleArmorSet = inventory.armor[0].isOf(Tropicraft.scaleBoots) && inventory.armor[1].isOf(Tropicraft.scaleLeggings) && inventory.armor[2].isOf(Tropicraft.scaleChestplate) && inventory.armor[3].isOf(Tropicraft.scaleHelmet);
        }
    }

    @Override
    public boolean living_baseTick(LivingEntity instance, Operation<Boolean> original) {
        return original.call(instance) || wearingScaleArmorSet;
    }

    @Override
    public boolean entity_baseTick(Entity instance, Operation<Boolean> original) {
        return original.call(instance) || wearingScaleArmorSet;
    }

    @Override
    public boolean entity_setOnFire(Entity instance, Operation<Boolean> original) {
        return original.call(instance) || wearingScaleArmorSet;
    }

    @Override
    public boolean entity_damage(Entity instance, Operation<Boolean> original) {
        return original.call(instance) || wearingScaleArmorSet;
    }
}
