package net.danygames2014.tropicraft.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

import static net.danygames2014.tropicraft.Tropicraft.*;

public class CreativeListener {
    public static CreativeTab tropicraftTab;

    @SuppressWarnings("DuplicatedCode")
    @EventListener
    public void onTabInit(TabRegistryEvent event) {
        tropicraftTab = new SimpleTab(NAMESPACE.id("tropicraft"), bambooShootItem);
        event.register(tropicraftTab);

        add(bambooShootItem);
        add(bambooBundle);
        add(bambooPlanks);
        add(bambooStairs);
        add(bambooSlab);
        add(bambooFence);
        add(bambooFenceGate);
        add(bambooChest);
        add(bambooStickItem);

        add(thatchBundle);
        add(thatchBlock);
        add(thatchStairs);
        add(thatchSlab);
        add(thatchRoof);
        add(thatchFence);
        add(thatchFenceGate);

        add(palmLog);
        add(palmLeaves);
        add(palmSapling);
        add(palmPlanks);
        add(palmStairs);
        add(palmSlab);
        add(palmFence);
        add(palmFenceGate);

        add(chunkOHead);
        add(chunkOSlab);
        add(chunkOStairs);

        add(sifter);
        add(purifiedSand);

        add(pineapple);
        add(pineappleCubes);
        add(coconut);
        add(coconutChunk);
        //add(pinaColada);

        add(commelinaDiffusa);
        add(crocosmia);
        add(orchid);
        add(canna);
        add(anemone);
        add(orange_anthurium);
        add(red_anthurium);
        add(magic_mushroom);
        add(pathos);
        add(acai_vine);
        add(croton);
        add(dracaena);
        add(fern);
        add(foliage);
        add(bromeliad);
        add(iris);

        add(scale);
        add(scaleHelmet);
        add(scaleChestplate);
        add(scaleLeggings);
        add(scaleBoots);

        add(easternIslesRecord);
        add(buriedTreasureRecord);
        add(tradeWindsRecord);
        add(lowTideRecord);
        add(summeringRecord);
        add(theTribeRecord);

        add(froxShell);
        add(pabShell);
        add(rubeShell);
        add(solonoxShell);
        add(starfishShell);
        add(whitePearl);
        add(blackPearl);
    }

    private static void add(Block block) {
        tropicraftTab.addItem(new ItemStack(block));
    }

    private static void add(Item item) {
        tropicraftTab.addItem(new ItemStack(item));
    }
}
