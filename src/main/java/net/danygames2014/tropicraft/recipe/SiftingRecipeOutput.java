package net.danygames2014.tropicraft.recipe;

import net.minecraft.item.ItemStack;

public class SiftingRecipeOutput {
    public ItemStack stack;

    /**
     * 1 in [value] chance => 100 will be 1 in 100 chance
     */
    public int chance;

    public SiftingRecipeOutput(ItemStack stack, int chance) {
        this.stack = stack;
        this.chance = chance;
    }

    public SiftingRecipeOutput(ItemStack stack){
        this(stack, 10);
    }
}
