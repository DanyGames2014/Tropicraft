package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.init.BiomeListener;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Arrays;

public class TropicsBiomeSource extends BiomeSource {
    private final TropiNoiseSampler terrainNoise;
    
    public TropicsBiomeSource(World world, TropicsDimension tropicsDimension) {
        super(world);
        terrainNoise = tropicsDimension.terrainNoise;
    }

    @Override
    public Biome getBiome(ChunkPos chunkPos) {
        return this.getBiome(chunkPos.x << 4, chunkPos.z << 4);
    }

    double lowest = Double.MAX_VALUE;
    double highest = Double.MIN_VALUE;

    @Override
    public Biome getBiome(int x, int z) {
        double sample = terrainNoise.samplePoint(x, z, 0.003D, 0.003D) * 1.9D;

        if (sample <= lowest) {
            System.out.println("LOWEST: " + lowest + " | HIGHEST: " + highest);
            lowest = sample;
        }

        if (sample >= highest) {
            System.out.println("LOWEST: " + lowest + " | HIGHEST: " + highest);
            highest = sample;
        }

        if (sample <= -0.71D) {
            return BiomeListener.TROPICS_ISLAND_DEEP;
        } else if (sample <= -0.62D) {
            return BiomeListener.TROPICS_ISLAND;
        } else if (sample <= -0.30D) {
            return BiomeListener.TROPICS_DEEP_OCEAN;
        } else if (sample <= -0.1D) {
            return BiomeListener.TROPICS_OCEAN;
        } else if (sample <= 0.0D) {
            return BiomeListener.TROPICS_BEACH;
        } else {
            return BiomeListener.TROPICS;
        }
    }

    @Override
    public double getTemperature(int x, int z) {
        return 1.0F;
    }

    @Override
    public double[] create(double[] temperatures, int x, int z, int width, int depth) {
        if (temperatures == null || temperatures.length < width * depth)
            temperatures = new double[width * depth];
        Arrays.fill(temperatures, 0, width * depth, 1.0F);
        return temperatures;
    }

    @Override
    public Biome[] getBiomesInArea(Biome[] biomes, int x, int z, int width, int depth) {
        if (biomes == null || biomes.length < width * depth) {
            biomes = new Biome[width * depth];
        }

        if (temperatureMap == null || biomes.length < width * depth) {
            temperatureMap = new double[width * depth];
            downfallMap = new double[width * depth];
        }

        Arrays.fill(biomes, 0, width * depth, BiomeListener.TROPICS);

        return biomes;
    }
}
