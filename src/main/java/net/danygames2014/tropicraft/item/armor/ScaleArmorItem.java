package net.danygames2014.tropicraft.item.armor;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.item.ArmorTextureProvider;
import net.modificationstation.stationapi.api.template.item.TemplateArmorItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ScaleArmorItem extends TemplateArmorItem implements ArmorTextureProvider {

    public ScaleArmorItem(Identifier identifier, int type, int slot) {
        super(identifier, type, 0, slot);
    }

    @Override
    public Identifier getTexture(ArmorItem armor) {
        return Tropicraft.NAMESPACE.id("scale_layer");
    }

//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//        long nanoTime = System.nanoTime();
//        if(entity.fire > 0){
//            if(entity instanceof PlayerEntity player){
//                for (int i = 0; i < player.inventory.armor.length; i++) {
//                    if(!(player.inventory.armor[i].getItem() instanceof ScaleArmorItem)){
//                        return;
//                    }
//                    entity.fire = 0;
//                    stack.damage(1, null);
//                }
//            }
//        }
//        System.out.println("CHECK TOOK : " + (System.nanoTime() - nanoTime) + "ns");
//    }
}
