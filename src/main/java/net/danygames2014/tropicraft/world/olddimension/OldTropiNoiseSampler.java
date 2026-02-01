package net.danygames2014.tropicraft.world.olddimension;

import net.danygames2014.tropicraft.util.PerlinNoise2D;
import net.minecraft.util.math.noise.NoiseSampler;

import java.util.Random;

public class OldTropiNoiseSampler extends NoiseSampler {
    private final PerlinNoise2D sampler;

    public OldTropiNoiseSampler(Random random, int octaves) {
        this(random, octaves, 0.5D, 2.0D);
    }

    public OldTropiNoiseSampler(Random random, int octaves, double persistence, double lacunarity) {
        this.sampler = new PerlinNoise2D(random.nextLong(), octaves, persistence, lacunarity);
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
