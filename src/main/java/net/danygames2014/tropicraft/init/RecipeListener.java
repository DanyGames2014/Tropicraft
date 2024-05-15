package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.event.SiftingRecipeRegisterEvent;
import net.danygames2014.tropicraft.recipe.SiftingRecipe;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeListener {

    @EventListener
    public void registerSiftingRecipes(SiftingRecipeRegisterEvent event) {
        SiftingRecipe sand = event.registerRecipe(Block.SAND.asItem(), new ArrayList<>(), 100);
        sand.addOutput(new ItemStack(Tropicraft.purifiedSand, 1), 1);
        sand.addOutput(new ItemStack(Tropicraft.froxShell, 1), 10);
        sand.addOutput(new ItemStack(Tropicraft.rubeShell, 1), 2);
        sand.addOutput(new ItemStack(Tropicraft.pabShell, 1), 10);
        sand.addOutput(new ItemStack(Tropicraft.solonoxShell, 1), 7);
        sand.addOutput(new ItemStack(Tropicraft.starfishShell, 1), 12);
        sand.addOutput(new ItemStack(Tropicraft.whitePearl, 1), 25);
        sand.addOutput(new ItemStack(Tropicraft.blackPearl, 1), 25);
    }
}
