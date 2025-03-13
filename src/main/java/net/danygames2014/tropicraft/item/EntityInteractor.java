package net.danygames2014.tropicraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


public interface EntityInteractor {
    void interactWithEntity(ItemStack stack, Entity entity, PlayerEntity player);

    /**
     * @param stack The stack used to attack the entity
     * @param entity The entity being attacked
     * @param player The player attacking the entity
     * @return Whether the attack should be allowed. <code>true</code> to cancel the attack, <code>false</code> to allow the attack
     */
    default boolean attackEntity(ItemStack stack, Entity entity, PlayerEntity player) {
        return true;
    }
}
