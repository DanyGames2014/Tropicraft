package net.danygames2014.tropicraft.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.States;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.StringIdentifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TikiTorchBlock extends TemplateBlock {
    public static final EnumProperty<TikiTorchPart> TIKI_TORCH_PART = EnumProperty.of("part", TikiTorchPart.class);

    public TikiTorchBlock(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setBoundingBox(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
        this.setTickRandomly(true);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockState(x, y, z).get(TIKI_TORCH_PART) == TikiTorchPart.UPPER) {
            world.addParticle("smoke", x + 0.5, y + 0.7, z + 0.5, 0.0, 0.0, 0.0);
            world.addParticle("flame", x + 0.5, y + 0.7, z + 0.5, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TIKI_TORCH_PART);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(TIKI_TORCH_PART, TikiTorchPart.LOWER);
    }

    @Override
    public void onPlaced(World world, int x, int y, int z) {
        if (!world.getBlockState(x, y + 1, z).isAir() || !world.getBlockState(x, y + 2, z).isAir()) {
            return;
        }

        if (world.getBlockState(x, y, z).get(TIKI_TORCH_PART) == TikiTorchPart.LOWER) {
            world.setBlockState(x, y + 1, z, this.getDefaultState().with(TIKI_TORCH_PART, TikiTorchPart.MIDDLE));
            world.setBlockState(x, y + 2, z, this.getDefaultState().with(TIKI_TORCH_PART, TikiTorchPart.UPPER));
        }
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z, int side) {
        return world.getBlockState(x, y + 1, z).isAir() && world.getBlockState(x, y + 2, z).isAir();
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        checkValidPlacement(world, x, y, z);
    }

    // checkValidPlacement
    protected void checkValidPlacement(World world, int x, int y, int z) {
        BlockState state = world.getBlockState(x, y, z);

        switch (state.get(TIKI_TORCH_PART)) {
            case UPPER -> {
                if (!(world.getBlockState(x, y - 1, z).isOf(this) && world.getBlockState(x, y - 1, z).get(TIKI_TORCH_PART) == TikiTorchPart.MIDDLE)) {
                    dropStack(world, x, y, z, new ItemStack(this.asItem(), 1, 0));
                    world.setBlockStateWithNotify(x, y, z, States.AIR.get());
                }
            }
            case MIDDLE -> {
                if (!(world.getBlockState(x, y - 1, z).isOf(this) && world.getBlockState(x, y - 1, z).get(TIKI_TORCH_PART) == TikiTorchPart.LOWER)) {
                    world.setBlockStateWithNotify(x, y, z, States.AIR.get());
                }

                if (!(world.getBlockState(x, y + 1, z).isOf(this) && world.getBlockState(x, y + 1, z).get(TIKI_TORCH_PART) == TikiTorchPart.UPPER)) {
                    world.setBlockStateWithNotify(x, y, z, States.AIR.get());
                }
            }
            case LOWER -> {
                if (!(world.getBlockState(x, y + 1, z).isOf(this) && world.getBlockState(x, y + 1, z).get(TIKI_TORCH_PART) == TikiTorchPart.MIDDLE)) {
                    world.setBlockStateWithNotify(x, y, z, States.AIR.get());
                }
            }
        }
    }


    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return Box.createCached(0.4375, 0.0, 0.4375, 0.5625, 1.0, 0.5625);
    }

    @Override
    public List<ItemStack> getDropList(World world, int x, int y, int z, BlockState state, int meta) {
        ArrayList<ItemStack> drops = new ArrayList<>();

        if (state.get(TIKI_TORCH_PART) == TikiTorchPart.UPPER) {
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

    public enum TikiTorchPart implements StringIdentifiable {
        UPPER("upper"),
        MIDDLE("middle"),
        LOWER("lower");

        final String id;

        TikiTorchPart(String id) {
            this.id = id;
        }

        @Override
        public String asString() {
            return id;
        }
    }
}
