package net.danygames2014.tropicraft.mixin.scalearmor;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.LivingEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends EntityMixin {

    @WrapOperation(method = "baseTick", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/entity/LivingEntity;fireImmune:Z"))
    public boolean living_baseTick(LivingEntity instance, Operation<Boolean> original) {
        return original.call(instance);
    }
}
