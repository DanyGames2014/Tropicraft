package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.*;
import net.danygames2014.tropicraft.block.template.SlabBlockTemplate;
import net.danygames2014.tropicraft.block.template.StairsBlockTemplate;
import net.danygames2014.tropicraft.item.food.FoodChunkItem;
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
    public static Block thatchRoof;
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
    public static Block iris;

    // Pineapple
    public static Block pineapple;
    public static Item pineappleCubes;

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
        thatchBlock = new TemplateBlock(NAMESPACE.id("thatch_bundle"), Material.WOOD).setTranslationKey(NAMESPACE, "thatch_bundle").setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchStairs = new StairsBlockTemplate(NAMESPACE.id("thatch_stairs"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_stairs")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchSlab = new SlabBlockTemplate(NAMESPACE.id("thatch_slab"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_slab")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchRoof = new StairsBlockTemplate(NAMESPACE.id("thatch_roof"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_roof")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);

        // Palm
        palmLog = new TemplateBlock(NAMESPACE.id("palm_log"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_log").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmLeaves = new TemplateBlock(NAMESPACE.id("palm_leaves"), Material.LEAVES).setTranslationKey(NAMESPACE, "palm_leaves").setHardness(0.2F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        palmPlanks = new TemplateBlock(NAMESPACE.id("palm_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmStairs = new StairsBlockTemplate(NAMESPACE.id("palm_stairs"), palmPlanks).setTranslationKey(NAMESPACE, "palm_stairs").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmSlab = new SlabBlockTemplate(NAMESPACE.id("palm_slab"), palmPlanks).setTranslationKey(NAMESPACE, "palm_slab").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        coconut = new CoconutBlock(NAMESPACE.id("coconut"), Material.WOOD).setTranslationKey(NAMESPACE, "coconut").setHardness(0.5F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        coconutChunk = new CoconutChunkItem(NAMESPACE.id("coconut_chunk")).setTranslationKey(NAMESPACE, "coconut_chunk");

        // Flowers
        commelinaDiffusa = new FlowerBlock(NAMESPACE.id("commelina_diffusa")).setTranslationKey(NAMESPACE, "commelina_diffusa").setSoundGroup(Block.DIRT_SOUND_GROUP);
        crocosmia = new FlowerBlock(NAMESPACE.id("crocosmia")).setTranslationKey(NAMESPACE, "crocosmia").setSoundGroup(Block.DIRT_SOUND_GROUP);
        orchid = new FlowerBlock(NAMESPACE.id("orchid")).setTranslationKey(NAMESPACE, "orchid").setSoundGroup(Block.DIRT_SOUND_GROUP);
        canna = new FlowerBlock(NAMESPACE.id("canna")).setTranslationKey(NAMESPACE, "canna").setSoundGroup(Block.DIRT_SOUND_GROUP);
        anemone = new FlowerBlock(NAMESPACE.id("anemone")).setTranslationKey(NAMESPACE, "anemone").setSoundGroup(Block.DIRT_SOUND_GROUP);
        orange_anthurium = new FlowerBlock(NAMESPACE.id("orange_anthurium")).setTranslationKey(NAMESPACE, "orange_anthurium").setSoundGroup(Block.DIRT_SOUND_GROUP);
        red_anthurium = new FlowerBlock(NAMESPACE.id("red_anthurium")).setTranslationKey(NAMESPACE, "red_anthurium").setSoundGroup(Block.DIRT_SOUND_GROUP);
        magic_mushroom = new FlowerBlock(NAMESPACE.id("magic_mushroom")).setTranslationKey(NAMESPACE, "magic_mushroom").setSoundGroup(Block.DIRT_SOUND_GROUP);
        pathos = new FlowerBlock(NAMESPACE.id("pathos")).setTranslationKey(NAMESPACE, "pathos").setSoundGroup(Block.DIRT_SOUND_GROUP);
        acai_vine = new FlowerBlock(NAMESPACE.id("acai_vine")).setTranslationKey(NAMESPACE, "acai_vine").setSoundGroup(Block.DIRT_SOUND_GROUP);
        croton = new FlowerBlock(NAMESPACE.id("croton")).setTranslationKey(NAMESPACE, "croton").setSoundGroup(Block.DIRT_SOUND_GROUP);
        dracaena = new FlowerBlock(NAMESPACE.id("dracaena")).setTranslationKey(NAMESPACE, "dracaena").setSoundGroup(Block.DIRT_SOUND_GROUP);
        fern = new FlowerBlock(NAMESPACE.id("fern")).setTranslationKey(NAMESPACE, "fern").setSoundGroup(Block.DIRT_SOUND_GROUP);
        foliage = new FlowerBlock(NAMESPACE.id("foliage")).setTranslationKey(NAMESPACE, "foliage").setSoundGroup(Block.DIRT_SOUND_GROUP);
        bromeliad = new FlowerBlock(NAMESPACE.id("bromeliad")).setTranslationKey(NAMESPACE, "bromeliad").setSoundGroup(Block.DIRT_SOUND_GROUP);
        iris = new TallFlowerBlock(NAMESPACE.id("iris")).setTranslationKey(NAMESPACE, "iris").setSoundGroup(Block.DIRT_SOUND_GROUP);

        // Pineapple
        pineapple = new PineappleBlock(NAMESPACE.id("pineapple")).setTranslationKey(NAMESPACE, "pineapple").setSoundGroup(Block.DIRT_SOUND_GROUP);
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        // Bamboo
        bambooShootItem = new BlockStateItem(NAMESPACE.id("bamboo_shoot"), bambooShootBlock.getDefaultState()).setTranslationKey(NAMESPACE, "bamboo");


        // Pineapple
        pineappleCubes = new FoodChunkItem(NAMESPACE.id("pineapple_cubes")).setTranslationKey(NAMESPACE, "pineapple_cubes");

        // Drinks
        pinaColada = new PinaColadaItem(NAMESPACE.id("pina_colada")).setTranslationKey(NAMESPACE, "pina_colada");
    }

    @EventListener
    public void registerDimension(DimensionRegistryEvent event) {
        DimensionRegistry registry = event.registry;
        event.registry.register(NAMESPACE.id("tropics"), new DimensionContainer<>(TropicsDimension::new));
    }
}
