package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.init.BiomeListener;
import net.danygames2014.tropicraft.world.biome.TropiBiome;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Arrays;

public class TropicsBiomeSource extends BiomeSource {
    public TropicsDimension tropicsDimension;
    
    public TropiNoiseSampler2D continentalNoise;
    public TropiNoiseSampler2D erosionNoise;
    public TropiNoiseSampler2D peaksValleysNoise;
    public TropiNoiseSampler2D riverNoise;
    public TropiNoiseSampler2D biomeNoise;

    public TropicsBiomeSource(World world, TropicsDimension tropicsDimension) {
        super(world);
        this.tropicsDimension = tropicsDimension;
        
        this.continentalNoise = tropicsDimension.continentalNoise;
        this.erosionNoise = tropicsDimension.erosionNoise;
        this.peaksValleysNoise = tropicsDimension.peakValleyNoise;
        this.riverNoise = tropicsDimension.riverNoise;
        this.biomeNoise = tropicsDimension.biomeNoise;
    }

    @Override
    public Biome getBiome(ChunkPos chunkPos) {
        return this.getBiome(chunkPos.x << 4, chunkPos.z << 4);
    }

    @Override
    public Biome getBiome(int x, int z) {
        double c = continentalNoise.samplePoint(x, z, 0.001, 0.001) * 1.9D;
        double e = erosionNoise.samplePoint(x, z, 0.005, 0.005);
        double riv = Math.abs(riverNoise.samplePoint(x, z, 0.0025, 0.0025));

        return getBiome(x, z, c, e, riv);
    }

    public Biome getBiome(int x, int z, double c, double e, double riv) {
        return getTropiBiome(x, z, c, e, riv).biome;
    }

    double lowest = Double.MAX_VALUE;
    double highest = Double.MIN_VALUE;
    
    public TropiBiome getTropiBiome(int x, int z, double c, double e, double riv) {
        // River
        if (c > -0.1 && riv < 0.06D) {
            // River Bed
            return BiomeListener.TROPICS_RIVER;
        }

        // Mainland (1.0 to 0.0)
        if (c > -0.05D) {
            double value = biomeNoise.samplePoint(x, z, 0.002, 0.002) * 1.9D;
            
            highest = Math.max(highest, value);
            lowest = Math.min(lowest, value);
            
            if (value > 0.5D) {
                return BiomeListener.TROPICS_RAINFOREST;
            }
            
            if (value > -0.1D && value < 0.35D) {
                return BiomeListener.TROPICS_ORCHARD;
            }
            
            if (value > -0.7D && value < -0.4D) {
                return BiomeListener.TROPICS_PLAINS;
            }
            
            return BiomeListener.TROPICS;
        }

        // Mainland Beach / Shallows (0.0 to -0.1)
        if (c > -0.1D) {
            return BiomeListener.TROPICS_BEACH;
        }
        
        // Ocean (-0.1 to -0.4)
        if (c > -0.4D) {
            return BiomeListener.TROPICS_OCEAN;
        }
        
        // Deep Ocean (-0.4 to -0.8)
        if (c > -0.7D) {
            return BiomeListener.TROPICS_DEEP_OCEAN;
        }

        // Tropical Island & its surroundings (-0.7 to -1.0)
        if (c <= -0.7D) {
            // Tropical Island Beach (-0.8 to -1.0)
            if (c < -0.85D) {
                return BiomeListener.TROPICS_ISLAND;
            }

            return BiomeListener.TROPICS_ISLAND_BEACH;
        }

        // Stone Layers
        return BiomeListener.TROPICS;
    }

    @Override
    public double getTemperature(int x, int z) {
        return 1.0F;
    }

    @Override
    public double[] create(double[] temperatures, int x, int z, int width, int depth) {
        if (temperatures == null || temperatures.length < width * depth) {
            temperatures = new double[width * depth];
        }
        
        Arrays.fill(temperatures, 0, width * depth, 1.0D);
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

        Arrays.fill(biomes, 0, width * depth, BiomeListener.TROPICS.biome);

        return biomes;
    }
}
