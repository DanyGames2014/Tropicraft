package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.BambooBlock;
import net.danygames2014.tropicraft.block.template.SlabBlockTemplate;
import net.danygames2014.tropicraft.block.template.StairsBlockTemplate;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.item.BlockStateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Tropicraft {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Block bambooShoot;
    public static Block bambooPlanksBlock;
    public static Block bambooStairs;
    public static Block bambooSlab;
    //public static Block bambooFence;

    public static Item bambooItem;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        bambooShoot = new BambooBlock(NAMESPACE.id("bamboo_shoot")).setTranslationKey(NAMESPACE, "bamboo_block").disableAutoItemRegistration();
        bambooPlanksBlock = new TemplateBlock(NAMESPACE.id("bamboo_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "bamboo_planks").setHardness(1.0F).setResistance(0.1F);
        bambooStairs = new StairsBlockTemplate(NAMESPACE.id("bamboo_stairs"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_stairs").setHardness(1.0F).setResistance(0.1F);
        bambooSlab = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_slab").setHardness(1.0F).setResistance(0.1F);
        //bambooFence = new TemplateFenceBlock(NAMESPACE.id("bamboo_fence"), 0).setTranslationKey(NAMESPACE, "bamboo_fence").setHardness(1.0F).setResistance(0.1F);
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        bambooItem = new BlockStateItem(NAMESPACE.id("bamboo_shoot"), bambooShoot.getDefaultState()).setTranslationKey(NAMESPACE, "bamboo");
    }
}
