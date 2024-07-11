package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.color.item.ItemColorsRegisterEvent;

public class ColorizerListener {
    @EventListener
    public void registerColorizers(ItemColorsRegisterEvent event){
        event.itemColors.register((itemStack, layer) -> {
            return layer == 1 ? itemStack.getDamage() : 16777215;
        }, Tropicraft.colorCloner);
    }
}
