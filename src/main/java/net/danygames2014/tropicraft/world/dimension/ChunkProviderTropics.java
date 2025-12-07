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
import net.modificationstation.stationapi.impl.world.chunk.ChunkSection;
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

    private void setChunkState(FlattenedChunk chunk, int x, int y, int z, BlockState state){
        ChunkSection section = chunk.getOrCreateSection(y, true);
        if (section == null) {
            return;
        }
        
        section.setBlockState(x, y & 15, z, state);
        chunk.dirty = true;
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
                
                int height = 63;

                // Fill the surface
                if (biome == BiomeListener.TROPICS) {
                    height = height + (int) (noiseHeight * 15D);
                    chunk.setBlockState(x, height, z, Block.GRASS_BLOCK.getDefaultState());
                    
                } else if (biome == BiomeListener.TROPICS_BEACH) {
                    height = height + (int) (noiseHeight * 3D);
                    chunk.setBlockState(x, height, z, Block.SAND.getDefaultState());
                    
                } else if (biome == BiomeListener.TROPICS_OCEAN) {
                    height = (height - 1) + (int) (noiseHeight * 8D);
                    chunk.setBlockState(x, height, z, Block.DIAMOND_BLOCK.getDefaultState());
                    
                    BlockState waterState = Block.GLASS.getDefaultState();
                    for (int i = height + 1; i < 64; i++) {
                        //setChunkState(chunk, x, i, z, waterState);
                    }
                    
                } else if (biome == BiomeListener.TROPICS_DEEP_OCEAN) {
                    if (noiseHeight < - 0.5D) {
                        // Readable code for reference:
                        // Invert the sum of the value below -0.5 to be above -0.5 (e.g it will turn -0.6 to -0.4)
                        // double newNoiseHeight = -noiseHeight - 1.0D;
                        
                        // Normalize the value from between -0.50 and -0.38 to -0.50 to -0.10 
                        // 10/3 (~3.333) is the scaling factor because the new range is that many times larger than the input one
                        // Difference between -0.50 and -0.38 is 0.12, meanwhille difference between -0.50 and -0.10 is -0.40
                        // 0.40 / 0.12 = 3.3333
                        // newNoiseHeight = (10.0D / 3.0D) * (newNoiseHeight + 0.50D) - 0.50D;
                        
                        // An optimized implementation:
                        double newNoiseHeight = (-10.0D / 3.0D) * noiseHeight - (13.0D / 6.0D);
                        
                        height = height + (int) (newNoiseHeight * 14D);
                    } else {
                        height = height + (int) (noiseHeight * 14D);
                    }
                    
                    chunk.setBlockState(x, height, z, Block.LAPIS_BLOCK.getDefaultState());

                    BlockState waterState = Block.GLASS.getDefaultState();
                    for (int i = height + 1; i < 64; i++) {
                        //setChunkState(chunk, x, i, z, waterState);
                    }
                    
                } else if (biome == BiomeListener.TROPICS_ISLAND) {
                    height = height + (int) ((noiseHeight + 0.62D) * -27D);
                    chunk.setBlockState(x, height, z, Tropicraft.purifiedSand.getDefaultState());
                    
                } else if (biome == BiomeListener.TROPICS_ISLAND_DEEP) {
                    height = height + (int) (noiseHeight * -4D);
                    chunk.setBlockState(x, height, z, Block.GRASS_BLOCK.getDefaultState());
                    
                } else {
                    chunk.setBlockState(x, height, z, Block.BEDROCK.getDefaultState());
                }

                // Fill the stone below
                BlockState stoneState = Block.STONE.getDefaultState();
                for (int y = 1; y < height; y++) {
                    setChunkState(chunk, x, y, z, stoneState);
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
