package net.danygames2014.tropicraft.mixin;

import net.danygames2014.spawneggs.item.SpawnEggItem;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnEggItem.class)
public class SpawnEggItemMixin {

    @Redirect(method = "spawnEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;method_1340(DDD)V"))
    public void a(Entity entity, double x, double y, double z) {
        entity.method_1340(x, y + Math.min(entity.spacingY, 0.5F), z);
    }
}
