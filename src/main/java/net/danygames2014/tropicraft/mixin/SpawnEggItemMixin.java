package net.danygames2014.tropicraft.mixin;

import net.danygames2014.spawneggs.item.SpawnEggItem;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnEggItem.class)
public class SpawnEggItemMixin {

    @Redirect(method = "spawnEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setPos(DDD)V"))
    public void a(Entity entity, double x, double y, double z) {
        entity.setPos(x, y + Math.min(entity.height, 0.5F), z);
    }
}
