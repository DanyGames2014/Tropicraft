package net.danygames2014.tropicraft.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {
    @Accessor("jumping")
    boolean jumping();

    @Accessor("sidewaysSpeed")
    float rightMovement();

    @Accessor("forwardSpeed")
    float frontMovement();
}
