package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.init.BiomeListener;
import net.danygames2014.tropicraft.world.olddimension.OldTropiNoiseSampler;
import net.danygames2014.tropicraft.world.olddimension.OldTropicsDimension;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.Arrays;

public class TropicsBiomeSource extends BiomeSource {
    public TropicsBiomeSource(World world, TropicsDimension tropicsDimension) {
        super(world);
    }

    @Override
    public Biome getBiome(ChunkPos chunkPos) {
        return this.getBiome(chunkPos.x << 4, chunkPos.z << 4);
    }

    @Override
    public Biome getBiome(int x, int z) {
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

        Arrays.fill(biomes, 0, width * depth, BiomeListener.TROPICS.biome);

        return biomes;
    }
}
