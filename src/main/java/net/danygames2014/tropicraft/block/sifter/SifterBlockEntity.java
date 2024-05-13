package net.danygames2014.tropicraft.block.sifter;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class SifterBlockEntity extends BlockEntity {
    public int siftTimeRemaining;

    public ItemStack siftedItem;

    public double yaw = 0.0D;
    public double yaw2 = 0.0D;

    public SifterBlockEntity() {
        this.siftTimeRemaining = -1;
        this.siftedItem = null;
    }

    @Override
    public void tick() {
        if(siftTimeRemaining > 0){
            siftTimeRemaining--;
        }

        this.yaw2 = this.yaw2 % 360.0D;
        this.yaw += 4.545454502105713D;

        if(!world.isRemote && siftTimeRemaining == 0){
            finishSifting(this.siftedItem);
            this.siftedItem = null;
            siftTimeRemaining = -1;
        }
    }

    public boolean sift(ItemStack item){
        if(this.siftTimeRemaining == -1 && item != null){
            this.siftedItem = item;
            // TODO: Customize Sifting time using a Sifting Recipe Registry
            this.siftTimeRemaining = 100;
            return true;
        }
        return false;
    }

    public void finishSifting(ItemStack siftedItem){
        // TODO: proper handling of finished sifting via Sifting Recipe Reigstry
        world.method_210(new ItemEntity(world, x, y+1, z, new ItemStack(Item.DIAMOND, 10)));
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("siftTimeRemaining", siftTimeRemaining);
        if(siftTimeRemaining >= 0){
            nbt.put("siftedItem", siftedItem.writeNbt(new NbtCompound()));
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        siftTimeRemaining = nbt.getInt("siftTimeRemaining");
        if(siftTimeRemaining >= 0){
            siftedItem = new ItemStack(nbt.getCompound("siftedItem"));
        }
    }
}
