package net.danygames2014.tropicraft.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {
    @Accessor("jumping")
    boolean jumping();

    @Accessor("field_1060")
    float rightMovement();

    @Accessor("field_1029")
    float frontMovement();
}
