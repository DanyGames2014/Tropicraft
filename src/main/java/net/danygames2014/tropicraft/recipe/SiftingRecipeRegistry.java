package net.danygames2014.tropicraft.recipe;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class SiftingRecipeRegistry {
    public static final HashMap<Item, SiftingRecipe> RECIPES = new HashMap<>();

    public static SiftingRecipe registerRecipe(Item input, ArrayList<SiftingRecipeOutput> outputs, int siftingTime){
        if(!RECIPES.containsKey(input)){
            SiftingRecipe recipe = new SiftingRecipe(outputs, siftingTime);
            RECIPES.put(input, recipe);
            return RECIPES.get(input);
        }

        return null;
    }

    /**
     * Returns a {@link SiftingRecipe} for the input {@link Item}, if no recipe exists, returns null
     * @param input The {@link Item} to return a recipe for
     * @return Recipe if found, null if not found
     */
    public static SiftingRecipe getRecipe(Item input){
        return RECIPES.get(input);
    }

    /**
     * Returns a {@link SiftingRecipe} for the input {@link Item}, if no recipe exists creates a new one and returns it
     * @param input The {@link Item} to return a recipe for
     * @return Recipe if found, recipe with no outputs and default sifting time if not found
     */
    public static SiftingRecipe getOrCreate(Item input){
        if(!RECIPES.containsKey(input)){
            registerRecipe(input, new ArrayList<>(), 100);
        }

        return RECIPES.get(input);
    }


    /**
     * Checks if there is a recipe for the specified item
     * @param input Item to check a recipe for
     * @return true if there is a recipe, false if there isnt a recipe
     */
    public static boolean hasRecipe(Item input){
        return RECIPES.containsKey(input);
    }
}
