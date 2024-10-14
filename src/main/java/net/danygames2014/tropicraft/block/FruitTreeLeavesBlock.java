package net.danygames2014.tropicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.BooleanProperty;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class FruitTreeLeavesBlock extends TemplateBlock {
    public static final EnumProperty<FruitTreeVariant> VARIANT = EnumProperty.of("variant", FruitTreeVariant.class);
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.of("has_fruit");

    public FruitTreeLeavesBlock(Identifier identifier) {
        super(identifier, Material.LEAVES);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(VARIANT);
        builder.add(HAS_FRUIT);
    }

    @Override
    public int getColor(int meta) {
        return FoliageColors.getDefaultColor();
    }

    @Override
    public int getColorMultiplier(BlockView blockView, int x, int y, int z) {
        blockView.method_1781().getBiomesInArea(x, z, 1, 1);
        return FoliageColors.getColor(blockView.method_1781().temperatureMap[0], blockView.method_1781().downfallMap[0]);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(VARIANT, FruitTreeVariant.GENERIC).with(HAS_FRUIT, false);
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        BlockState state = world.getBlockState(x, y, z);

        if (player.isSneaking()) {
            world.setBlockStateWithNotify(x,y,z,state.cycle(VARIANT));
        } else {
            world.setBlockStateWithNotify(x,y,z,state.cycle(HAS_FRUIT));
        }

        return true;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return true;
    }
}
