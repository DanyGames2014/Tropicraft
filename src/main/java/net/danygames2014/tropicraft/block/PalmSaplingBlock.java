package net.danygames2014.tropicraft.block;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.ChunkDecorationListener;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class PalmSaplingBlock extends TemplateBlock {
    public PalmSaplingBlock(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTickRandomly(true);
    }

    @Override
    public boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {
        return generateTree(world,world.field_214, x, y, z);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        generateTree(world,random, x, y, z);
    }

    public boolean generateTree(World world, Random random, int x, int y, int z) {
        if (world.getBlockState(x, y - 1, z).isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Tropicraft.NAMESPACE.id("palm_grows_on")))) {
            switch(random.nextInt(6)) {
                case 0,1,2 -> {
                    return ChunkDecorationListener.smallPalmTreeFeature.generate(world, random, x, y, z, true);
                }
                case 3,4 -> {
                    return ChunkDecorationListener.curvedPalmTreeFeature.generate(world, random, x, y, z, true);
                }
                case 5 -> {
                    return ChunkDecorationListener.tallPalmTreeFeature.generate(world, random, x, y, z, true);
                }
            }
        }
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
