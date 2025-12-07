package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.init.BiomeListener;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.LoadingDisplay;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSource;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.impl.world.chunk.FlattenedChunk;

import java.util.Random;

public class ChunkProviderTropics implements ChunkSource {
    private final World world;
    public Random random;

    private final TropiNoiseSampler terrainNoise;

    public ChunkProviderTropics(World world, long seed, TropicsDimension tropicsDimension) {
        this.world = world;
        this.random = new Random(seed);
        this.terrainNoise = tropicsDimension.terrainNoise;
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return true;
    }

    @Override
    public Chunk loadChunk(int chunkX, int chunkZ) {
        return this.getChunk(chunkX, chunkZ);
    }

    @Override
    public Chunk getChunk(int chunkX, int chunkZ) {
        FlattenedChunk chunk = new FlattenedChunk(world, chunkX, chunkZ);

        // Place Bedrock Layer
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunk.setBlockState(x, 0, z, Block.BEDROCK.getDefaultState());
            }
        }

        // Every other layer
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                Biome biome = this.world.method_1781().getBiome((chunkX << 4) + x, (chunkZ << 4) + z);

                double noiseHeight = terrainNoise.samplePoint((chunkX << 4) + x, (chunkZ << 4) + z, 0.003D, 0.003D) * 1.9D;
                int height = 63 + (int) (noiseHeight * 15D);

                BlockState stoneState = Block.STONE.getDefaultState();

                // Fill the stone below
                for (int y = 1; y < height; y++) {
                    chunk.setBlockState(x, y, z, stoneState);
                }

                if (biome == BiomeListener.TROPICS) {
                    chunk.setBlockState(x, height, z, Block.GRASS_BLOCK.getDefaultState());
                } else if (biome == BiomeListener.TROPICS_DUNES) {
                    chunk.setBlockState(x, height, z, Tropicraft.purifiedSand.getDefaultState());
                } else if (biome == BiomeListener.TROPICS_OCEAN) {
                    chunk.setBlockState(x, height, z, Block.DIAMOND_BLOCK.getDefaultState());
                } else if (biome == BiomeListener.TROPICS_DEEP_OCEAN) {
                    chunk.setBlockState(x, height, z, Block.LAPIS_BLOCK.getDefaultState());
                } else if (biome == BiomeListener.TROPICS_ISLAND) {
                    chunk.setBlockState(x, height, z, Block.GOLD_BLOCK.getDefaultState());
                } else if (biome == BiomeListener.TROPICS_ISLAND_DEEP) {
                    chunk.setBlockState(x, height, z, Block.IRON_BLOCK.getDefaultState());
                } else {
                    chunk.setBlockState(x, height, z, Block.BEDROCK.getDefaultState());
                }
            }
        }

        chunk.populateHeightMap();
        chunk.populateBlockLight();

        return chunk;
    }

    @Override
    public void decorate(ChunkSource source, int x, int z) {

    }

    @Override
    public boolean save(boolean flag, LoadingDisplay loadingDisplay) {
        return true;
    }

    @Override
    public boolean tick() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String getDebugInfo() {
        return "TropicsChunkSource";
    }
}
