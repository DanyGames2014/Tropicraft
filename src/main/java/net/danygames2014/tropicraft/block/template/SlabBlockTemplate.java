package net.danygames2014.tropicraft.block.template;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.math.Direction;
import net.modificationstation.stationapi.api.world.BlockStateView;

import java.util.List;
import java.util.Random;

public class SlabBlockTemplate extends TemplateBlock {

    public static final EnumProperty<SlabType> SLAB_TYPE = EnumProperty.of("slab_type", SlabType.class);
    Block doubleBlock;
    boolean doubleSlab;


    public SlabBlockTemplate(Identifier identifier, Block baseBlock, Block doubleBlock) {
        super(identifier, baseBlock.material);
        this.doubleBlock = doubleBlock;
        this.doubleSlab = false;
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    public SlabBlockTemplate(Identifier identifier, Block baseBlock) {
        super(identifier, baseBlock.material);
        this.doubleBlock = null;
        this.doubleSlab = true;
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void updateBoundingBox(BlockView blockView, int x, int y, int z) {
        if (!(blockView instanceof BlockStateView view)) {
            return;
        }

        switch (view.getBlockState(x, y, z).get(SLAB_TYPE)) {
            case BOTTOM -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            case TOP -> this.setBoundingBox(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            case DOUBLE -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            default ->
                    throw new IllegalStateException("Unexpected value: " + ((World) blockView).getBlockState(x, y, z).get(SLAB_TYPE));
        }
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SLAB_TYPE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = getDefaultState();
        Direction side = context.getSide();

        if (this.doubleSlab) {
            return state.with(SLAB_TYPE, SlabType.DOUBLE);
        }

        if (side == Direction.DOWN) {
            return state.with(SLAB_TYPE, SlabType.TOP);
        } else {
            return state.with(SLAB_TYPE, SlabType.BOTTOM);
        }
    }

    @Override
    public void onPlaced(World world, int x, int y, int z, int direction) {
        // 1 = Placed on bottom face
        // 0 = Placed on top face

        if (!this.doubleSlab) {
            if (direction == 1 || direction == 0) {
                int offset = direction == 0 ? 1 : -1;

                if (world.getBlockId(x, y + offset, z) == this.id) {
                    if (direction == 0 && world.getBlockState(x, y + offset, z).get(SLAB_TYPE) == SlabType.TOP) {
                        world.setBlock(x, y, z, 0);
                        world.setBlockState(x, y + offset, z, doubleBlock.getDefaultState().with(SLAB_TYPE, SlabType.DOUBLE));
                    } else if (direction == 1 && world.getBlockState(x, y + offset, z).get(SLAB_TYPE) == SlabType.BOTTOM) {
                        world.setBlock(x, y, z, 0);
                        world.setBlockState(x, y + offset, z, doubleBlock.getDefaultState().with(SLAB_TYPE, SlabType.DOUBLE));
                    }
                }
            }
        }
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return doubleSlab ? 2 : 1;
    }

    @Override
    public boolean isFullCube() {
        return doubleSlab;
    }

    @Override
    public boolean isOpaque() {
        return doubleSlab;
    }
}
