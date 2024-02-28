package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.BambooBlock;
import net.danygames2014.tropicraft.block.template.SlabBlockTemplate;
import net.danygames2014.tropicraft.block.template.StairsBlockTemplate;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Tropicraft {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();


    public static Block bambooBlock;
    public static Block bambooPlanksBlock;
    public static Block bambooStairs;
    public static Block bambooSlab;
    public static Block bambooSlabDouble;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        bambooBlock = new BambooBlock(NAMESPACE.id("bamboo_block")).setTranslationKey(NAMESPACE, "bamboo_block");
        bambooPlanksBlock = new TemplateBlock(NAMESPACE.id("bamboo_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "bamboo_planks").setHardness(1.0F).setResistance(0.1F);
        bambooStairs = new StairsBlockTemplate(NAMESPACE.id("bamboo_stairs"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_stairs").setHardness(1.0F).setResistance(0.1F);
        bambooSlabDouble = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab_double"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_slab_souble").setHardness(1.0F).setResistance(0.1F);
        bambooSlab = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab"), bambooPlanksBlock, bambooSlabDouble).setTranslationKey(NAMESPACE, "bamboo_slab").setHardness(1.0F).setResistance(0.1F);
    }
}
