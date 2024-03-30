package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.BambooShootBlock;
import net.danygames2014.tropicraft.block.CoconutBlock;
import net.danygames2014.tropicraft.block.TropiFlowerBlock;
import net.danygames2014.tropicraft.block.template.SlabBlockTemplate;
import net.danygames2014.tropicraft.block.template.StairsBlockTemplate;
import net.danygames2014.tropicraft.item.food.CoconutChunkItem;
import net.danygames2014.tropicraft.item.food.PinaColadaItem;
import net.danygames2014.tropicraft.world.dimension.TropicsDimension;
import net.glasslauncher.mods.api.gcapi.api.GConfig;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.DimensionRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.DimensionContainer;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.item.BlockStateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

@SuppressWarnings("unused")
public class Tropicraft {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @GConfig(value = "worldgen", visibleName = "Worldgen")
    public static final Config.WorldgenConfig WORLDGEN_CONFIG = new Config.WorldgenConfig();

    // Bamboo
    public static Block bambooShootBlock;
    public static Block bambooBundle;
    public static Block bambooStairs;
    public static Block bambooSlab;
    // TODO : Bamboo Fence
    // TODO : Bamboo Fence Gate
    // TODO : Bamboo Chest
    // TODO : Bamboo Ladder
    // TODO : Bamboo Door
    // TODO : ???Bamboo Item Frame???
    public static Item bambooShootItem;
    // TODO : Bamboo Stick
    // TODO : Bamboo Mug
    // TODO : Bamboo Spear
    // TODO : Bamboo Fishing Rod

    // Thatch
    public static Block thatchBlock;
    public static Block thatchStairs;
    public static Block thatchSlab;
    // TODO : Thatch Roof
    // TODO : Thatch Fence
    // TODO : Thatch Fence Gate

    // Palm
    public static Block palmLog;
    public static Block palmLeaves;
    // TODO : Palm Sapling
    public static Block palmPlanks;
    public static Block palmStairs;
    public static Block palmSlab;
    // TODO : Palm Fence
    // TODO : Palm Fence Gate

    public static Block coconut;
    public static Item coconutChunk;

    // Flowers
    public static Block commelinaDiffusa;
    public static Block crocosmia;
    public static Block orchid;
    public static Block canna;
    public static Block anemone;
    public static Block orange_anthurium;
    public static Block red_anthurium;
    public static Block magic_mushroom;
    public static Block pathos;
    public static Block acai_vine;
    public static Block croton;
    public static Block dracaena;
    public static Block fern;
    public static Block foliage;
    public static Block bromeliad;
    // TODO : Iris

    // Drinks
    public static Item pinaColada;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        // Bamboo
        bambooShootBlock = new BambooShootBlock(NAMESPACE.id("bamboo_shoot")).setTranslationKey(NAMESPACE, "bamboo_block").disableAutoItemRegistration().setSoundGroup(Block.DIRT_SOUND_GROUP);
        bambooBundle = new TemplateBlock(NAMESPACE.id("bamboo_bundle"), Material.WOOD).setTranslationKey(NAMESPACE, "bamboo_bundle").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooStairs = new StairsBlockTemplate(NAMESPACE.id("bamboo_stairs"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_stairs").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooSlab = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_slab").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        // Thatch
        thatchBlock = new TemplateBlock(NAMESPACE.id("thatch_bundle"), Material.WOOD).setTranslationKey(NAMESPACE, "thatch_bundle").setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        thatchStairs = new StairsBlockTemplate(NAMESPACE.id("thatch_stairs"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_stairs")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        thatchSlab = new SlabBlockTemplate(NAMESPACE.id("thatch_slab"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_slab")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        // Palm
        palmLog = new TemplateBlock(NAMESPACE.id("palm_log"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_log").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmLeaves = new TemplateBlock(NAMESPACE.id("palm_leaves"), Material.LEAVES).setTranslationKey(NAMESPACE, "palm_leaves").setHardness(0.2F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmPlanks = new TemplateBlock(NAMESPACE.id("palm_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmStairs = new StairsBlockTemplate(NAMESPACE.id("palm_stairs"), palmPlanks).setTranslationKey(NAMESPACE, "palm_stairs").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmSlab = new SlabBlockTemplate(NAMESPACE.id("palm_slab"), palmPlanks).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        coconut = new CoconutBlock(NAMESPACE.id("coconut"), Material.WOOD).setTranslationKey(NAMESPACE, "coconut").setHardness(0.5F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        coconutChunk = new CoconutChunkItem(NAMESPACE.id("coconut_chunk")).setTranslationKey(NAMESPACE, "coconut_chunk");

        // Flowers
        commelinaDiffusa = new TropiFlowerBlock(NAMESPACE.id("commelina_diffusa")).setTranslationKey(NAMESPACE, "commelina_diffusa");
        crocosmia = new TropiFlowerBlock(NAMESPACE.id("crocosmia")).setTranslationKey(NAMESPACE, "crocosmia");
        orchid = new TropiFlowerBlock(NAMESPACE.id("orchid")).setTranslationKey(NAMESPACE, "orchid");
        canna = new TropiFlowerBlock(NAMESPACE.id("canna")).setTranslationKey(NAMESPACE, "canna");
        anemone = new TropiFlowerBlock(NAMESPACE.id("anemone")).setTranslationKey(NAMESPACE, "anemone");
        orange_anthurium = new TropiFlowerBlock(NAMESPACE.id("orange_anthurium")).setTranslationKey(NAMESPACE, "orange_anthurium");
        red_anthurium = new TropiFlowerBlock(NAMESPACE.id("red_anthurium")).setTranslationKey(NAMESPACE, "red_anthurium");
        magic_mushroom = new TropiFlowerBlock(NAMESPACE.id("magic_mushroom")).setTranslationKey(NAMESPACE, "magic_mushroom");
        pathos = new TropiFlowerBlock(NAMESPACE.id("pathos")).setTranslationKey(NAMESPACE, "pathos");
        acai_vine = new TropiFlowerBlock(NAMESPACE.id("acai_vine")).setTranslationKey(NAMESPACE, "acai_vine");
        croton = new TropiFlowerBlock(NAMESPACE.id("croton")).setTranslationKey(NAMESPACE, "croton");
        dracaena = new TropiFlowerBlock(NAMESPACE.id("dracaena")).setTranslationKey(NAMESPACE, "dracaena");
        fern = new TropiFlowerBlock(NAMESPACE.id("fern")).setTranslationKey(NAMESPACE, "fern");
        foliage = new TropiFlowerBlock(NAMESPACE.id("foliage")).setTranslationKey(NAMESPACE, "foliage");
        bromeliad = new TropiFlowerBlock(NAMESPACE.id("bromeliad")).setTranslationKey(NAMESPACE, "bromeliad");
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        // Bamboo
        bambooShootItem = new BlockStateItem(NAMESPACE.id("bamboo_shoot"), bambooShootBlock.getDefaultState()).setTranslationKey(NAMESPACE, "bamboo");

        // Drinks
        pinaColada = new PinaColadaItem(NAMESPACE.id("pina_colada")).setTranslationKey(NAMESPACE, "pina_colada");
    }

    @EventListener
    public void registerDimension(DimensionRegistryEvent event) {
        DimensionRegistry registry = event.registry;
        event.registry.register(NAMESPACE.id("tropics"), new DimensionContainer<>(TropicsDimension::new));
    }
}
