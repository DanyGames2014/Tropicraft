package net.danygames2014.tropicraft.block.bamboochest;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateChestBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BambooChestBlock extends TemplateChestBlock {
    public static final EnumProperty<ChestType> CHEST_TYPE = EnumProperty.of("connected_chest_side", ChestType.class);

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
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(CHEST_TYPE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite()).with(CHEST_TYPE, ChestType.SINGLE);
    }

    public void checkChestConnection(World world, int x, int y, int z) {
        for (BlockPos offset : offsets) {
            if (canConnectTo(world, x, y, z, world.getBlockState(x + offset.x, y + offset.y, z + offset.z))) {

            }
        }
    }

    public boolean canConnectTo(World world, int x, int y, int z, BlockState otherChest) {
        BlockState state = world.getBlockState(x, y, z);
        if (state.isOf(this)) {
            if (state.get(Properties.HORIZONTAL_FACING) == otherChest.get(Properties.HORIZONTAL_FACING)) {
                return otherChest.get(CHEST_TYPE) == ChestType.SINGLE;
            }
        }
        return false;
    }
}
