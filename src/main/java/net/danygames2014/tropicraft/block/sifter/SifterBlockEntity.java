package net.danygames2014.tropicraft.block.sifter;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.recipe.SiftingRecipeOutput;
import net.danygames2014.tropicraft.recipe.SiftingRecipeRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class SifterBlockEntity extends BlockEntity {
    public int siftTimeRemaining;

    public ItemStack siftedItem;
    public ItemEntity renderedItem;

    public double yaw = 0.0D;
    public double yaw2 = 0.0D;

    public SifterBlockEntity() {
        this.siftTimeRemaining = -1;
        this.siftedItem = null;
    }

    @Override
    public void tick() {
        if (siftTimeRemaining > 0) {
            siftTimeRemaining--;
        }

        this.yaw2 = this.yaw2 % 360.0D;
        this.yaw += 4.545454502105713D;

        if (siftTimeRemaining == 0) {
            finishSifting();
        }
    }

    public boolean sift(ItemStack item) {
        if (siftTimeRemaining == -1 && item != null && SiftingRecipeRegistry.hasRecipe(item.getItem())) {
            siftedItem = item;
            siftedItem.count = 1;
            siftTimeRemaining = SiftingRecipeRegistry.getRecipe(item.getItem()).siftingTime;
            return true;
        }
        return false;
    }

    public void finishSifting() {
        if(!world.isRemote){
            for (SiftingRecipeOutput output : SiftingRecipeRegistry.getRecipe(siftedItem.getItem()).outputs) {
                if (world.field_214.nextInt(output.chance) == 0) {
                    // Thank you mine_diver for helping me figure out a bug here
                    world.method_210(new ItemEntity(world, x, y+1, z, output.stack.copy()));
                }
            }
        }

        renderedItem = null;
        siftedItem = null;
        siftTimeRemaining = -1;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("siftTimeRemaining", siftTimeRemaining);
        if (siftTimeRemaining >= 0) {
            nbt.put("siftedItem", siftedItem.writeNbt(new NbtCompound()));
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        siftTimeRemaining = nbt.getInt("siftTimeRemaining");
        if (siftTimeRemaining >= 0) {
            siftedItem = new ItemStack(nbt.getCompound("siftedItem"));
        }
    }
}
