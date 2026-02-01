package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.util.PerlinNoise2D;
import net.minecraft.util.math.noise.NoiseSampler;

import java.util.Random;

public class TropiNoiseSampler2D extends NoiseSampler {
    private final PerlinNoise2D sampler;

    public TropiNoiseSampler2D(int seed, int octaves) {
        this(seed, octaves, 0.5D, 2.0D);
    }

    public TropiNoiseSampler2D(int seed, int octaves, double persistence, double lacunarity) {
        this.sampler = new PerlinNoise2D(seed, octaves, persistence, lacunarity);
    }

    public double samplePoint(double x, double z, double scaleX, double scaleZ) {
        return sampler.sample(x, z, scaleX, scaleZ);
    }

    public double[] sample(double[] map, double x, double z, int sizeX, int sizeZ, double scaleX, double scaleZ) {
        return new double[sizeX * sizeZ];
    }
}
