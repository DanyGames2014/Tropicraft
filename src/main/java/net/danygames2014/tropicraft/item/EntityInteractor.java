package net.danygames2014.tropicraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


public interface EntityInteractor {
    void interactWithEntity(ItemStack stack, Entity entity, PlayerEntity player);
}
