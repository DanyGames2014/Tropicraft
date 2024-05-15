package net.danygames2014.tropicraft.recipe;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class SiftingRecipe {
    public ArrayList<SiftingRecipeOutput> outputs;
    public int siftingTime;

    public SiftingRecipe(ArrayList<SiftingRecipeOutput> outputs, int siftingTime) {
        this.outputs = outputs;
        this.siftingTime = siftingTime;
    }

    public SiftingRecipe(ArrayList<SiftingRecipeOutput> outputs) {
        this.outputs = outputs;
        this.siftingTime = 100;
    }

    public void addOutput(ItemStack output, int chance){
        this.outputs.add(new SiftingRecipeOutput(output, chance));
    }
}
