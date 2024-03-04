package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.BambooShootBlock;
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
import net.modificationstation.stationapi.api.template.block.TemplateSaplingBlock;
import net.modificationstation.stationapi.api.template.item.BlockStateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Tropicraft {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Block bambooShootBlock;
    public static Block bambooPlanksBlock;
    public static Block bambooStairs;
    public static Block bambooSlab;
    //public static Block bambooFence;

    public static Block palmLog;
    public static Block palmLeaves;
    public static Block palmSapling;
    public static Block palmPlanks;
    public static Block palmStairs;
    public static Block palmSlab;

    public static Item bambooShootItem;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        // Bamboo
        bambooShootBlock = new BambooShootBlock(NAMESPACE.id("bamboo_shoot")).setTranslationKey(NAMESPACE, "bamboo_block").disableAutoItemRegistration();
        bambooPlanksBlock = new TemplateBlock(NAMESPACE.id("bamboo_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "bamboo_planks").setHardness(1.0F).setResistance(0.1F);
        bambooStairs = new StairsBlockTemplate(NAMESPACE.id("bamboo_stairs"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_stairs").setHardness(1.0F).setResistance(0.1F);
        bambooSlab = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab"), bambooPlanksBlock).setTranslationKey(NAMESPACE, "bamboo_slab").setHardness(1.0F).setResistance(0.1F);
        //bambooFence = new TemplateFenceBlock(NAMESPACE.id("bamboo_fence"), 0).setTranslationKey(NAMESPACE, "bamboo_fence").setHardness(1.0F).setResistance(0.1F);
        //bambooFenceGate
        //bambooChest

        // Palm
        palmLog = new TemplateBlock(NAMESPACE.id("palm_log"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_log").setHardness(1.0F).setResistance(0.1F);
        palmLeaves = new TemplateBlock(NAMESPACE.id("palm_leaves"), Material.LEAVES).setTranslationKey(NAMESPACE, "palm_leaves").setHardness(0.2F).setResistance(0.1F);
        //palmSapling
        palmPlanks = new TemplateBlock(NAMESPACE.id("palm_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F);
        palmStairs = new StairsBlockTemplate(NAMESPACE.id("palm_stairs"), palmPlanks).setTranslationKey(NAMESPACE, "palm_stairs").setHardness(1.0F).setResistance(0.1F);
        palmSlab = new SlabBlockTemplate(NAMESPACE.id("palm_slab"), palmPlanks).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F);
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        // Bamboo
        bambooShootItem = new BlockStateItem(NAMESPACE.id("bamboo_shoot"), bambooShootBlock.getDefaultState()).setTranslationKey(NAMESPACE, "bamboo");
        //bambooSpear
        //bambooMug
    }
}
