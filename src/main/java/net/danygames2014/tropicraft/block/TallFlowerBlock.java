package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.States;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.StringIdentifiable;

import java.util.ArrayList;
import java.util.List;

public class TallFlowerBlock extends TemplateBlock {

    public static final EnumProperty<FlowerHalf> FLOWER_HALF = EnumProperty.of("half", FlowerHalf.class);

    public TallFlowerBlock(Identifier identifier) {
        super(identifier, Material.field_988);
        this.setBoundingBox(0.2F, 0.0f, 0.2F, 0.8F, 1.0f, 0.8F);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FLOWER_HALF);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FLOWER_HALF, FlowerHalf.BOTTOM);
    }

    @Override
    public void onPlaced(World world, int x, int y, int z) {
        if (world.getBlockState(x, y + 1, z).isAir() && world.getBlockState(x, y, z).get(FLOWER_HALF) == FlowerHalf.BOTTOM) {
            world.setBlockState(x, y + 1, z, this.getDefaultState().with(FLOWER_HALF, FlowerHalf.TOP));
        }
    }

    @Override
    public void onBreak(World world, int x, int y, int z) {
        BlockState stateBottom = world.getBlockState(x,y-1,z);

        if (stateBottom.isOf(this) && stateBottom.get(FLOWER_HALF) == FlowerHalf.BOTTOM) {
            world.setBlockState(x, y - 1, z, States.AIR.get());
        }
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z, int side) {
        if (!world.getBlockState(x, y + 1, z).isAir()) {
            return false;
        }
        // This is only for placing, not growing
        return world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("flower_grows_on")));
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        this.checkValidPlacement(world, x, y, z);
    }

    protected final void checkValidPlacement(World world, int x, int y, int z) {
        if (!this.canGrow(world, x, y, z)) {
            if (world.getBlockState(x, y, z).get(FLOWER_HALF) == FlowerHalf.TOP) {
                this.dropStack(world, x, y, z, new ItemStack(this.asItem(), 1, 0));
            }
            world.setBlock(x, y, z, 0);
        }
    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        if (world.getBlockState(x, y, z).isOf(this) && world.getBlockState(x, y, z).get(FLOWER_HALF) == FlowerHalf.TOP) {
            return world.getBlockState(x, y - 1, z).isOf(this) && world.getBlockState(x, y - 1, z).get(FLOWER_HALF) == FlowerHalf.BOTTOM;
        } else if (world.getBlockState(x, y, z).isOf(this) && world.getBlockState(x, y, z).get(FLOWER_HALF) == FlowerHalf.BOTTOM) {
            return world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("flower_grows_on")));
        }
        return false;
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public List<ItemStack> getDropList(World world, int x, int y, int z, BlockState state, int meta) {
        ArrayList<ItemStack> drops = new ArrayList<>();

        if (state.get(FLOWER_HALF) == FlowerHalf.TOP) {
            drops.add(new ItemStack(this, 1));
        }

        return drops;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    public enum FlowerHalf implements StringIdentifiable {
        TOP("top"),
        BOTTOM("bottom");

        final String flowerHalf;

        FlowerHalf(String flowerHalf) {
            this.flowerHalf = flowerHalf;
        }

        @Override
        public String asString() {
            return this.flowerHalf;
        }
    }
}
