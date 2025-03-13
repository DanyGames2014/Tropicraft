package net.danygames2014.tropicraft.item;

import net.danygames2014.tropicraft.entity.Dyeable;
import net.danygames2014.tropicraft.util.ColorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Formatting;
import net.modificationstation.stationapi.api.util.Identifier;

public class ColorClonerItem extends TemplateItem implements EntityInteractor, CustomTooltipProvider {
    public ColorClonerItem(Identifier identifier) {
        super(identifier);
        this.setMaxCount(1);
    }

    @Override
    public void interactWithEntity(ItemStack stack, Entity entity, PlayerEntity player) {
        if (!player.world.isRemote) {
            if (entity instanceof Dyeable dyeable) {
                NbtCompound nbt = stack.getStationNbt();
                if (player.isSneaking()) {
                    nbt.putInt("color", dyeable.getColor());
                } else {
                    if (nbt.contains("color")) {
                        dyeable.setColor(nbt.getInt("color"));
                    }
                }
            }
        }
    }

    @Override
    public boolean attackEntity(ItemStack stack, Entity entity, PlayerEntity player) {
        if (!player.world.isRemote) {
            if (entity instanceof Dyeable dyeable) {
                if (player.isSneaking()) {
                    dyeable.setColor(ColorHelper.getColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        return new String[]{
                originalTooltip, 
                "Current Color: " + stack.getStationNbt().getInt("color"),
                "",
                Formatting.GRAY + "Shift + RMB to save color. ",
                Formatting.GRAY + "RMB to apply color. ",
                Formatting.GRAY + "Shift + LMB to randomize color."
        };
    }
}
