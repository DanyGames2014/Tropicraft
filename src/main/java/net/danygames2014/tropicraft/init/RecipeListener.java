package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.event.SiftingRecipeRegisterEvent;
import net.danygames2014.tropicraft.recipe.SiftingRecipe;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeListener {

    @EventListener
    public void registerSiftingRecipes(SiftingRecipeRegisterEvent event){
        SiftingRecipe sand = event.registerRecipe(Block.SAND.asItem(), new ArrayList<>(), 100);
        sand.addOutput(new ItemStack(Item.DIAMOND, 1), 10);
        sand.addOutput(new ItemStack(Item.BED, 1), 50);
        sand.addOutput(new ItemStack(Tropicraft.coconut, 1), 2);
        sand.addOutput(new ItemStack(Tropicraft.coconut, 1), 2);
        sand.addOutput(new ItemStack(Tropicraft.coconut, 1), 2);
    }
}
