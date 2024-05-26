package net.danygames2014.tropicraft.item.food;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class PinaColadaItem extends TemplateFoodItem {
    public PinaColadaItem(Identifier identifier) {
        super(identifier, 2, false);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        System.out.print(world.getSeed());
        user.method_490(world.getSeed() + "");
//        DimensionHelper.switchDimension(
//                user,
//                Tropicraft.NAMESPACE.id("tropics"),
//                1,
//                new class_467()
//        );

        return stack;
    }
}
