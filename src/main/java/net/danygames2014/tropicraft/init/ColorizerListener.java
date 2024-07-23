package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.DyeItem;
import net.modificationstation.stationapi.api.client.event.color.item.ItemColorsRegisterEvent;

public class ColorizerListener {
    @EventListener
    public void registerColorizers(ItemColorsRegisterEvent event){
        event.itemColors.register((itemStack, layer) -> {
            return layer == 1 ? (itemStack.getStationNbt().contains("color") ? itemStack.getStationNbt().getInt("color") : 16777215) : 16777215;
        }, Tropicraft.colorCloner);

        event.itemColors.register((itemStack, layer) -> {
            if(itemStack.getDamage() == 16){
                return 16777215;
            }

            return layer == 1 ? DyeItem.colors[Math.min(itemStack.getDamage(), DyeItem.colors.length-1)] : 16777215;
        }, Tropicraft.beachChair);
    }
}
