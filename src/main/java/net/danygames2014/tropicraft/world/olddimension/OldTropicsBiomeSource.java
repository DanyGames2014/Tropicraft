package net.danygames2014.tropicraft.world.olddimension;

import net.danygames2014.tropicraft.init.BiomeListener;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Arrays;

public class OldTropicsBiomeSource extends BiomeSource {
    private final OldTropiNoiseSampler terrainNoise;
    private final OldTropiNoiseSampler landBiomeNoise;
    private final OldTropiNoiseSampler riverNoise;
    
    public OldTropicsBiomeSource(World world, OldTropicsDimension tropicsDimension) {
        super(world);
        terrainNoise = tropicsDimension.terrainNoise;
        landBiomeNoise = tropicsDimension.landBiomeNoise;
        riverNoise = tropicsDimension.riverNoise;
    }

    @Override
    public Biome getBiome(ChunkPos chunkPos) {
        return this.getBiome(chunkPos.x << 4, chunkPos.z << 4);
    }

    double lowest = Double.MAX_VALUE;
    double highest = Double.MIN_VALUE;

    @Override
    public Biome getBiome(int x, int z) {
        double terrainSample = terrainNoise.samplePoint(x, z, 0.003D, 0.003D) * 1.9D;
        
        if (terrainSample <= lowest) {
            System.out.println("LOWEST: " + lowest + " | HIGHEST: " + highest);
            lowest = terrainSample;
        }

        if (terrainSample >= highest) {
            System.out.println("LOWEST: " + lowest + " | HIGHEST: " + highest);
            highest = terrainSample;
        }

        // Water Biomes
        if (terrainSample <= -0.71D) {
            return BiomeListener.TROPICS_ISLAND_DEEP.biome;
        } else if (terrainSample <= -0.62D) {
            return BiomeListener.TROPICS_ISLAND.biome;
        } else if (terrainSample <= -0.30D) {
            return BiomeListener.TROPICS_DEEP_OCEAN.biome;
        } else if (terrainSample <= -0.1D) {
            return BiomeListener.TROPICS_OCEAN.biome;
        }
        
        // Rivers
        double riverSample = riverNoise.samplePoint(x, z, 0.001D, 0.001D) * 1.9D;

        if (riverSample > 0.0D && riverSample < 0.03D) {
            return BiomeListener.TROPICS_RIVER.biome;
        }

        // Beaches
        if (terrainSample < 0.0D) {
            return BiomeListener.TROPICS_BEACH.biome;
        }

        // Land Biomes
        double landBiomeSample = landBiomeNoise.samplePoint(x, z, 0.0025D, 0.0025D) * 1.9D;

//            if (landBiomeSample > 0.8D) {
//                return BiomeListener.TROPICS_DUNES;
//            } else if (landBiomeSample > 0.75D) {
//                return BiomeListener.TROPICS_RIVER;
//            } else if (landBiomeSample > 0.6D) {
//                return BiomeListener.TROPICS_ORCHARD;
//            }

        return BiomeListener.TROPICS.biome;
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
