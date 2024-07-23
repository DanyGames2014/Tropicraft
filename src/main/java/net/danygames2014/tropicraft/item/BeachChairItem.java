package net.danygames2014.tropicraft.item;

import net.danygames2014.tropicraft.entity.BeachChairEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class BeachChairItem extends DyeableSpawnerItem {
    public BeachChairItem(Identifier identifier) {
        super(identifier, BeachChairEntity.class);
        this.setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if (stack.getDamage() == 16) {
            return "item.tropicraft.random_beach_chair";
        }

        return "item.tropicraft." + DyeItem.names[Math.min(stack.getDamage(), DyeItem.names.length - 1)] + "_beach_chair";
    }

    @Override
    public void dyeEntity(ItemStack stack, Entity entity) {
        if (stack.getDamage() != 16) {
            super.dyeEntity(stack, entity);
        }
    }
}
