package net.danygames2014.tropicraft.item;

import net.danygames2014.tropicraft.entity.Dyeable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ColorClonerItem extends TemplateItem implements EntityInteractor {
    public ColorClonerItem(Identifier identifier) {
        super(identifier);
        this.setMaxCount(1);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.setDamage(-1);
    }

    @Override
    public void interactWithEntity(ItemStack stack, Entity entity, PlayerEntity player) {
        if (entity instanceof Dyeable dyeable) {
            if (player.isSneaking()) {
                stack.setDamage(dyeable.getColor());
            } else {
                if (stack.getDamage() != -1) {
                    dyeable.setColor(stack.getDamage());
                }
            }
        }
    }
}
