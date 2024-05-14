package net.danygames2014.tropicraft.recipe;

import net.minecraft.item.ItemStack;

public class SiftingRecipe {
    public SiftingRecipeOutput[] outputs;
    public int siftingTime;

    public SiftingRecipe(SiftingRecipeOutput[] outputs, int siftingTime) {
        this.outputs = outputs;
        this.siftingTime = siftingTime;
    }

    public SiftingRecipe(SiftingRecipeOutput[] outputs) {
        this.outputs = outputs;
        this.siftingTime = 100;
    }
}
