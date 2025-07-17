package net.danygames2014.tropicraft.mixin.scalearmor;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow protected boolean fireImmune;

    @WrapOperation(method = "baseTick", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/entity/Entity;fireImmune:Z"))
    public boolean entity_baseTick(Entity instance, Operation<Boolean> original) {
        return original.call(instance);
    }

    @WrapOperation(method = "setOnFire", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/entity/Entity;fireImmune:Z"))
    public boolean entity_setOnFire(Entity instance, Operation<Boolean> original){
        return original.call(instance);
    }

    @WrapOperation(method = "damage(I)V", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/entity/Entity;fireImmune:Z"))
    public boolean entity_damage(Entity instance, Operation<Boolean> original){
        return original.call(instance);
    }

}
