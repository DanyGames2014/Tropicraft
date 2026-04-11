package net.danygames2014.tropicraft.block.bamboochest;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateChestBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import javax.sound.sampled.BooleanControl;

public class BambooChestBlock extends TemplateChestBlock {
    public static final EnumProperty<ChestType> CHEST_TYPE = EnumProperty.of("chest_type", ChestType.class);

    public static final BlockPos[] offsets = new BlockPos[]{
            new BlockPos(0, 0, 1),
            new BlockPos(0, 0, -1),
            new BlockPos(1, 0, 0),
            new BlockPos(-1, 0, 0)
    };

    public BambooChestBlock(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        // If this fails, another mod (probably VBE) already registered a facing property on the Chest Block itself
        try {
            builder.add(Properties.HORIZONTAL_FACING);
        } catch (IllegalArgumentException ignored) {
            
        }
        
        builder.add(CHEST_TYPE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite()).with(CHEST_TYPE, ChestType.SINGLE);
    }

    @Override
    public void onPlaced(World world, int x, int y, int z) {
        super.onPlaced(world, x, y, z);
        this.checkChestConnection(world, x, y, z);
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        super.neighborUpdate(world, x, y, z, id);
        this.checkChestConnection(world, x, y, z);
    }

    public void checkChestConnection(World world, int x, int y, int z) {
        BlockState state = world.getBlockState(x, y, z);

        boolean connected = false;
        for (BlockPos offset : offsets) {
            BlockState otherState = world.getBlockState(x + offset.x, y + offset.y, z + offset.z);
            if (canConnectTo(world, x, y, z, otherState)) {
                state = state.with(Properties.HORIZONTAL_FACING, otherState.get(Properties.HORIZONTAL_FACING));
                
                connected = true;
                switch (state.get(Properties.HORIZONTAL_FACING)) {
                    case EAST:
                        if (offset.x == -1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.LEFT));
                        } else if (offset.x == 1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.RIGHT));
                        }
                        break;

                    case WEST:
                        if (offset.x == 1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.LEFT));
                        } else if (offset.x == -1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.RIGHT));
                        }
                        break;

                    case NORTH:
                        if (offset.z == 1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.LEFT));
                        } else if (offset.z == -1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.RIGHT));
                        }
                        break;

                    case SOUTH:
                        if (offset.z == -1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.LEFT));
                        } else if (offset.z == 1) {
                            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.RIGHT));
                        }
                        break;
                }
            }
        }

        System.err.println(connected);
        if (!connected) {
            world.setBlockStateWithNotify(x, y, z, state.with(CHEST_TYPE, ChestType.SINGLE));
        }
    }

    public boolean canConnectTo(World world, int x, int y, int z, BlockState otherChest) {
        BlockState state = world.getBlockState(x, y, z);
        if (state.isOf(this) && otherChest.isOf(this)) {
            return true;
        }
        return false;
    }
}
