package net.danygames2014.tropicraft.item.food;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.math.Direction;

public class PinaColadaItem extends TemplateFoodItem {
    public PinaColadaItem(Identifier identifier) {
        super(identifier, 2, false);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
//        System.out.print(world.getSeed());
//        user.sendMessage(world.getSeed() + "");
//
//        user.sendMessage(world.method_1781().getBiome(MathHelper.floor(user.x), MathHelper.floor(user.z)).name);

        return stack;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        user.sendMessage(Direction.byId(side).getName());
        
        return super.useOnBlock(stack, user, world, x, y, z, side);
    }
}
