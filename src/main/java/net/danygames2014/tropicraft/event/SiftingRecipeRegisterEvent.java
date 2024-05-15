package net.danygames2014.tropicraft.event;

import net.danygames2014.tropicraft.recipe.SiftingRecipe;
import net.danygames2014.tropicraft.recipe.SiftingRecipeOutput;
import net.danygames2014.tropicraft.recipe.SiftingRecipeRegistry;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.StationAPI;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("UnstableApiUsage")
@EventPhases(StationAPI.INTERNAL_PHASE)
public class SiftingRecipeRegisterEvent extends Event {

    public SiftingRecipe registerRecipe(Item input, ArrayList<SiftingRecipeOutput> outputs, int siftingTime){
        return SiftingRecipeRegistry.registerRecipe(input, outputs, siftingTime);
    }

    /**
     * Returns a {@link SiftingRecipe} for the input {@link Item}, if no recipe exists, returns null
     * @param input The {@link Item} to return a recipe for
     * @return Recipe if found, null if not found
     */
    public SiftingRecipe getRecipe(Item input){
        return SiftingRecipeRegistry.getRecipe(input);
    }

    /**
     * Returns a {@link SiftingRecipe} for the input {@link Item}, if no recipe exists creates a new one and returns it
     * @param input The {@link Item} to return a recipe for
     * @return Recipe if found, recipe with no outputs and default sifting time if not found
     */
    public SiftingRecipe getOrCreate(Item input){
        return SiftingRecipeRegistry.getOrCreate(input);
    }

    /**
     * Checks if there is a recipe for the specified item
     * @param input Item to check a recipe for
     * @return true if there is a recipe, false if there isnt a recipe
     */
    public boolean hasRecipe(Item input){
        return SiftingRecipeRegistry.hasRecipe(input);
    }

    /**
     * @return The raw recipe registry HashMap
     */
    public HashMap<Item, SiftingRecipe> getRegistry(){
        return SiftingRecipeRegistry.RECIPES;
    }
}
