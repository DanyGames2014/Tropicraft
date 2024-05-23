package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.*;
import net.danygames2014.tropicraft.block.sifter.SifterBlock;
import net.danygames2014.tropicraft.block.template.FenceBlockTemplate;
import net.danygames2014.tropicraft.block.template.FenceGateBlockTemplate;
import net.danygames2014.tropicraft.block.template.SlabBlockTemplate;
import net.danygames2014.tropicraft.block.template.StairsBlockTemplate;
import net.danygames2014.tropicraft.block.sifter.SifterBlockEntity;
import net.danygames2014.tropicraft.block.sifter.SifterBlockEntityRenderer;
import net.danygames2014.tropicraft.entity.BeachChairEntity;
import net.danygames2014.tropicraft.entity.EIHEntity;
import net.danygames2014.tropicraft.entity.IguanaEntity;
import net.danygames2014.tropicraft.entity.renderer.BeachChairRenderer;
import net.danygames2014.tropicraft.entity.renderer.EIHRenderer;
import net.danygames2014.tropicraft.entity.renderer.IguanaRenderer;
import net.danygames2014.tropicraft.event.SiftingRecipeRegisterEvent;
import net.danygames2014.tropicraft.item.ShellItem;
import net.danygames2014.tropicraft.item.TropiRecordItem;
import net.danygames2014.tropicraft.item.armor.ScaleArmorItem;
import net.danygames2014.tropicraft.item.food.FoodChunkItem;
import net.danygames2014.tropicraft.item.food.PinaColadaItem;
import net.glasslauncher.mods.api.gcapi.api.GConfig;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.client.event.block.entity.BlockEntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.*;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.block.TemplateSandBlock;
import net.modificationstation.stationapi.api.template.item.BlockStateItem;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
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
    public static Block bambooFence;
    public static Block bambooFenceGate;
    // TODO : Bamboo Chest
    // TODO : Bamboo Ladder
    // TODO : Bamboo Door
    // TODO : ???Bamboo Item Frame???
    public static Item bambooShootItem;
    public static Item bambooStickItem;

    // TODO : Bamboo Mug
    // TODO : Bamboo Spear
    // TODO : Bamboo Fishing Rod

    // Thatch
    public static Block thatchBlock;
    public static Block thatchStairs;
    public static Block thatchSlab;
    public static Block thatchRoof;
    public static Block thatchFence;
    public static Block thatchFenceGate;

    // Palm
    public static Block palmLog;
    public static Block palmLeaves;
    // TODO : Palm Sapling
    public static Block palmPlanks;
    public static Block palmStairs;
    public static Block palmSlab;
    public static Block palmFence;
    public static Block palmFenceGate;
    public static Block coconut;
    public static Item coconutChunk;

    // Chunk o' Head
    public static Block chunkOHead;
    public static Block chunkOSlab;
    public static Block chunkOStairs;

    // Sifter
    public static Block sifter;
    public static Block purifiedSand;

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

    // Scale
    public static Item scale;
    public static Item scaleHelmet;
    public static Item scaleChestplate;
    public static Item scaleLeggings;
    public static Item scaleBoots;

    // Records
    public static Item easternIslesRecord;
    public static Item buriedTreasureRecord;
    public static Item lowTideRecord;
    public static Item summeringRecord;
    public static Item theTribeRecord;
    public static Item tradeWindsRecord;

    // Shells & Pearls
    public static Item froxShell;
    public static Item pabShell;
    public static Item rubeShell;
    public static Item solonoxShell;
    public static Item starfishShell;
    public static Item whitePearl;
    public static Item blackPearl;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        // Bamboo
        bambooShootBlock = new BambooShootBlock(NAMESPACE.id("bamboo_shoot")).setTranslationKey(NAMESPACE, "bamboo_block").disableAutoItemRegistration().setSoundGroup(Block.DIRT_SOUND_GROUP);
        bambooBundle = new TemplateBlock(NAMESPACE.id("bamboo_bundle"), Material.WOOD).setTranslationKey(NAMESPACE, "bamboo_bundle").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooStairs = new StairsBlockTemplate(NAMESPACE.id("bamboo_stairs"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_stairs").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooSlab = new SlabBlockTemplate(NAMESPACE.id("bamboo_slab"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_slab").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooFence = new FenceBlockTemplate(NAMESPACE.id("bamboo_fence"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_fence").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        bambooFenceGate = new FenceGateBlockTemplate(NAMESPACE.id("bamboo_fence_gate"), bambooBundle).setTranslationKey(NAMESPACE, "bamboo_fence_gate").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        // Thatch
        thatchBlock = new TemplateBlock(NAMESPACE.id("thatch_bundle"), Material.WOOD).setTranslationKey(NAMESPACE, "thatch_bundle").setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchStairs = new StairsBlockTemplate(NAMESPACE.id("thatch_stairs"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_stairs")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchSlab = new SlabBlockTemplate(NAMESPACE.id("thatch_slab"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_slab")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchRoof = new StairsBlockTemplate(NAMESPACE.id("thatch_roof"), thatchBlock).setTranslationKey(NAMESPACE.id("thatch_roof")).setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchFence = new FenceBlockTemplate(NAMESPACE.id("thatch_fence"), thatchBlock).setTranslationKey(NAMESPACE, "thatch_fence").setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        thatchFenceGate = new FenceGateBlockTemplate(NAMESPACE.id("thatch_fence_gate"), thatchBlock).setTranslationKey(NAMESPACE, "thatch_fence_gate").setHardness(0.1F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);


        // Palm
        palmLog = new TemplateBlock(NAMESPACE.id("palm_log"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_log").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmLeaves = new TemplateBlock(NAMESPACE.id("palm_leaves"), Material.LEAVES).setTranslationKey(NAMESPACE, "palm_leaves").setHardness(0.2F).setResistance(0.1F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        palmPlanks = new TemplateBlock(NAMESPACE.id("palm_planks"), Material.WOOD).setTranslationKey(NAMESPACE, "palm_planks").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmStairs = new StairsBlockTemplate(NAMESPACE.id("palm_stairs"), palmPlanks).setTranslationKey(NAMESPACE, "palm_stairs").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmSlab = new SlabBlockTemplate(NAMESPACE.id("palm_slab"), palmPlanks).setTranslationKey(NAMESPACE, "palm_slab").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmFence = new FenceBlockTemplate(NAMESPACE.id("palm_fence"), palmPlanks).setTranslationKey(NAMESPACE, "palm_fence").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        palmFenceGate = new FenceGateBlockTemplate(NAMESPACE.id("palm_fence_gate"), palmPlanks).setTranslationKey(NAMESPACE, "palm_fence_gate").setHardness(1.0F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        coconut = new CoconutBlock(NAMESPACE.id("coconut"), Material.WOOD).setTranslationKey(NAMESPACE, "coconut").setHardness(0.5F).setResistance(0.1F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        // Chunk o' Head
        chunkOHead = new TemplateBlock(NAMESPACE.id("chunk_o_head"), Material.STONE).setTranslationKey(NAMESPACE, "chunk_o_head").setHardness(2.0F).setResistance(30.0F).setSoundGroup(Block.STONE_SOUND_GROUP);
        chunkOSlab = new SlabBlockTemplate(NAMESPACE.id("chunk_o_slab"), chunkOHead).setTranslationKey(NAMESPACE, "chunk_o_slab").setHardness(2.0F).setResistance(30.0F).setSoundGroup(Block.STONE_SOUND_GROUP);
        chunkOStairs = new StairsBlockTemplate(NAMESPACE.id("chunk_o_stairs"), chunkOHead).setTranslationKey(NAMESPACE, "chunk_o_stairs").setHardness(2.0F).setResistance(30.0F).setSoundGroup(Block.STONE_SOUND_GROUP);

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

        // Sifter
        sifter = new SifterBlock(NAMESPACE.id("sifter")).setTranslationKey(NAMESPACE, "sifter").setSoundGroup(Block.WOOD_SOUND_GROUP);
        // TODO: Fix the falling texture of the Purified Sand
        purifiedSand = new TemplateSandBlock(NAMESPACE.id("purified_sand"), 0).setTranslationKey(NAMESPACE, "purified_sand").setSoundGroup(Block.SAND_SOUND_GROUP);
    }

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        // Bamboo
        bambooShootItem = new BlockStateItem(NAMESPACE.id("bamboo_shoot"), bambooShootBlock.getDefaultState()).setTranslationKey(NAMESPACE, "bamboo");
        bambooStickItem = new TemplateItem(NAMESPACE.id("bamboo_stick")).setTranslationKey(NAMESPACE, "bamboo_stick");

        // Coconut
        coconutChunk = new FoodChunkItem(NAMESPACE.id("coconut_chunk")).setTranslationKey(NAMESPACE, "coconut_chunk");

        // Pineapple
        pineappleCubes = new FoodChunkItem(NAMESPACE.id("pineapple_cubes")).setTranslationKey(NAMESPACE, "pineapple_cubes");

        // Drinks
        pinaColada = new PinaColadaItem(NAMESPACE.id("pina_colada")).setTranslationKey(NAMESPACE, "pina_colada");

        // Iguana
        scale = new TemplateItem(NAMESPACE.id("scale")).setTranslationKey(NAMESPACE, "scale");
        scaleHelmet = new ScaleArmorItem(NAMESPACE.id("scale_helmet"), 2, 0).setTranslationKey(NAMESPACE, "scale_helmet");
        scaleChestplate = new ScaleArmorItem(NAMESPACE.id("scale_chestplate"), 2, 1).setTranslationKey(NAMESPACE, "scale_chestplate");
        scaleLeggings = new ScaleArmorItem(NAMESPACE.id("scale_leggings"), 2, 2).setTranslationKey(NAMESPACE, "scale_leggings");
        scaleBoots = new ScaleArmorItem(NAMESPACE.id("scale_boots"), 2, 3).setTranslationKey(NAMESPACE, "scale_boots");

        // Records
        easternIslesRecord = new TropiRecordItem(NAMESPACE.id("eastern_isles_record"), "tropicraft:eastern_isles", "Frox - Eastern Isles").setTranslationKey(NAMESPACE.id("eastern_isles_record"));
        buriedTreasureRecord = new TropiRecordItem(NAMESPACE.id("buried_treasure_record"), "tropicraft:buried_treasure", "Punchaface - Buried Treasure").setTranslationKey(NAMESPACE.id("buried_treasure_record"));
        lowTideRecord = new TropiRecordItem(NAMESPACE.id("low_tide_record"), "tropicraft:low_tide", "Punchaface - Low Tide").setTranslationKey(NAMESPACE.id("low_tide_record"));
        summeringRecord = new TropiRecordItem(NAMESPACE.id("summering_record"), "tropicraft:summering", "Billy Christiansen - Summering").setTranslationKey(NAMESPACE.id("summering_record"));
        theTribeRecord = new TropiRecordItem(NAMESPACE.id("the_tribe_record"), "tropicraft:the_tribe", "Emile Van Krieken - The Tribe").setTranslationKey(NAMESPACE.id("the_tribe_record"));
        tradeWindsRecord = new TropiRecordItem(NAMESPACE.id("trade_winds_record"), "tropicraft:trade_winds", "Frox - Trade Winds").setTranslationKey(NAMESPACE.id("trade_winds_record"));

        // Shells and Pearls
        froxShell = new ShellItem(NAMESPACE.id("frox_shell")).setTranslationKey(NAMESPACE, "frox_shell");
        pabShell = new ShellItem(NAMESPACE.id("pab_shell")).setTranslationKey(NAMESPACE, "pab_shell");
        rubeShell = new ShellItem(NAMESPACE.id("rube_shell")).setTranslationKey(NAMESPACE, "rube_shell");
        solonoxShell = new ShellItem(NAMESPACE.id("solonox_shell")).setTranslationKey(NAMESPACE, "solonox_shell");
        starfishShell = new ShellItem(NAMESPACE.id("starfish_shell")).setTranslationKey(NAMESPACE, "starfish_shell");
        whitePearl = new TemplateItem(NAMESPACE.id("white_pearl")).setTranslationKey(NAMESPACE, "white_pearl");
        blackPearl = new TemplateItem(NAMESPACE.id("black_pearl")).setTranslationKey(NAMESPACE, "black_pearl");

    }

    @EventListener
    public void registerDimension(DimensionRegistryEvent event) {
        DimensionRegistry registry = event.registry;
//        event.registry.register(NAMESPACE.id("tropics"), new DimensionContainer<>(TropicsDimension::new));
    }

    @EventListener
    public void registerEntities(EntityRegister event) {
        event.register(BeachChairEntity.class, "beach_chair");
        event.register(IguanaEntity.class, "iguana");
        event.register(EIHEntity.class, "eih");
    }

    @EventListener
    public void registerEntityHandlers(EntityHandlerRegistryEvent event) {
        Registry.register(event.registry, NAMESPACE.id("beach_chair"), BeachChairEntity::new);

    }

    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        Registry.register(event.registry, NAMESPACE.id("iguana"), IguanaEntity::new);
        Registry.register(event.registry, NAMESPACE.id("eih"), EIHEntity::new);
    }

    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {
        event.renderers.put(BeachChairEntity.class, new BeachChairRenderer());
        event.renderers.put(IguanaEntity.class, new IguanaRenderer());
        event.renderers.put(EIHEntity.class, new EIHRenderer());
    }

    @EventListener
    public void registerBlockEntity(BlockEntityRegisterEvent event){
        event.register(SifterBlockEntity.class, "sifter");
    }

    @EventListener
    public void registerBlockEntityRenderer(BlockEntityRendererRegisterEvent event){
        event.renderers.put(SifterBlockEntity.class, new SifterBlockEntityRenderer());
    }

    @EventListener
    public void sendSiftingRecipeRegisterEvent(AfterBlockAndItemRegisterEvent event){
        StationAPI.EVENT_BUS.post(new SiftingRecipeRegisterEvent());
    }
}
