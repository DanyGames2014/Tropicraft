package net.danygames2014.tropicraft.item.food;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.entity.HasTeleportationManager;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.world.dimension.DimensionHelper;
import net.modificationstation.stationapi.api.world.dimension.TeleportationManager;

public class PinaColadaItem extends TemplateFoodItem {
    public PinaColadaItem(Identifier identifier) {
        super(identifier, 2, false);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        DimensionHelper.switchDimension(user, Tropicraft.NAMESPACE.id("tropics"), 1, null);

        return stack;
    }
}
