package net.danygames2014.tropicraft.world.dimension;

import net.minecraft.util.math.noise.NoiseSampler;
import net.minecraft.util.math.noise.PerlinNoiseSampler;

import java.util.Arrays;
import java.util.Random;

public class TropiNoiseSampler extends NoiseSampler {
    private final PerlinNoise2D sampler;

    public TropiNoiseSampler(Random random, int octaves) {
        this.sampler = new PerlinNoise2D(random.nextLong(), octaves, 0.5D, 2.0D);
    }

    public double samplePoint(double x, double z, double scaleX, double scaleZ) {
        return sampler.sample(x, z, scaleX, scaleZ);
    }

    public double[] sample(double[] map, double x, double z, int sizeX, int sizeZ, double scaleX, double scaleZ) {
        return new double[sizeX * sizeZ];
    }

    public double[] sample(double[] map, double x, double y, double z, int sizeX, int sizeZ, double scaleX, double scaleZ) {
        return new double[sizeX * sizeZ];
    }
}
