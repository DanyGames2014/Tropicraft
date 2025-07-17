package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
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
import java.util.Random;

public class PineappleBlock extends TemplateBlock {

    public static boolean chopped;

    public static final EnumProperty<PineappleHalf> PINEAPPLE_HALF = EnumProperty.of("half", PineappleHalf.class);

    public PineappleBlock(Identifier identifier) {
        super(identifier, Material.PLANT);
        this.setTickRandomly(true);
        this.setBoundingBox(0.2F, 0.0f, 0.2F, 0.8F, 1.0f, 0.8F);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PINEAPPLE_HALF);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        if (context.getWorld().getBlockState(context.getBlockPos().down()).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("chopping_blocks")))) {
            return getDefaultState().with(PINEAPPLE_HALF, PineappleHalf.TOP);
        }

        return getDefaultState().with(PINEAPPLE_HALF, PineappleHalf.BOTTOM);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockState(x, y, z).get(PINEAPPLE_HALF) == PineappleHalf.BOTTOM && random.nextInt(50) == 0) {
            if (world.getBlockState(x, y + 1, z).isAir()) {
                world.setBlockState(x, y + 1, z, this.getDefaultState().with(PINEAPPLE_HALF, PineappleHalf.TOP));
            }
        }
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z, int side) {
        BlockState stateBelow = world.getBlockState(x, y - 1, z);
        return stateBelow.isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("can_place_pineapple_on"))) || stateBelow.isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("chopping_blocks")));
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        this.checkValidPlacement(world, x, y, z);
    }

    protected final void checkValidPlacement(World world, int x, int y, int z) {
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("chopping_blocks")))) {
            return;
        }

        if (!this.canGrow(world, x, y, z)) {
            if (world.getBlockState(x, y, z).get(PINEAPPLE_HALF) == PineappleHalf.TOP) {
                this.dropStack(world, x, y, z, new ItemStack(Tropicraft.pineapple.asItem(), 1, 0));
            }
            world.setBlock(x, y, z, 0);
        }
    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        return world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("pineapple_grows_on")));
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        if ((player.inventory.getSelectedItem() != null) && (player.inventory.getSelectedItem().getItem() instanceof SwordItem)) {
            chop(world, x, y, z);
        }
    }

    public void chop(World world, int x, int y, int z) {
        chopped = true;
        this.dropStacks(world, x, y, z, 1);
        world.setBlock(x, y, z, 0);
        chopped = false;
    }

    @Override
    public List<ItemStack> getDropList(World world, int x, int y, int z, BlockState state, int meta) {
        ArrayList<ItemStack> drops = new ArrayList<>();

        // TODO: Remove this temporary patch when https://github.com/ModificationStation/StationAPI/issues/210 is fixed
        if(state.isAir()) {
            if (chopped) {
                drops.add(new ItemStack(Tropicraft.pineappleCubes, getRandomCubeCount(world.random)));
            } else {
                drops.add(new ItemStack(this, 1));
            }
            return drops;
        }
        
        if (state.get(PINEAPPLE_HALF) == PineappleHalf.TOP) {
            if (chopped) {
                drops.add(new ItemStack(Tropicraft.pineappleCubes, getRandomCubeCount(world.random)));
            } else {
                drops.add(new ItemStack(this, 1));
            }
        }

        return drops;
    }

    public int getRandomCubeCount(Random random) {
        if (chopped) {
            if (random.nextInt(7) == 0) {
                return 1;
            }
            if (random.nextInt(6) == 0) {
                return 2;
            }
            if (random.nextInt(5) == 0) {
                return 3;
            }
            return random.nextInt(4) == 0 ? 4 : 5;
        }
        return 1;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    public enum PineappleHalf implements StringIdentifiable {
        TOP("top"),
        BOTTOM("bottom");

        final String pineappleHalf;

        PineappleHalf(String pineappleHalf) {
            this.pineappleHalf = pineappleHalf;
        }

        @Override
        public String asString() {
            return this.pineappleHalf;
        }
    }
}
