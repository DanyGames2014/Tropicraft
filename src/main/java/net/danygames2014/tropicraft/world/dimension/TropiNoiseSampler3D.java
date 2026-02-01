package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.util.PerlinNoise3D;
import net.minecraft.util.math.noise.NoiseSampler;

import java.util.Random;

public class TropiNoiseSampler3D extends NoiseSampler {
    private final PerlinNoise3D sampler;

    public TropiNoiseSampler3D(int seed, int octaves) {
        this(seed, octaves, 0.5D, 2.0D);
    }

    public TropiNoiseSampler3D(int seed, int octaves, double persistence, double lacunarity) {
        this.sampler = new PerlinNoise3D(seed, octaves, persistence, lacunarity);
    }

    public double samplePoint(double x, double y, double z, double scaleX, double scaleY, double scaleZ) {
        return sampler.sample(x, y, z, scaleX, scaleY, scaleZ);
    }

    public double[] sample(double[] map, double x, double y, double z, int sizeX, int sizeY, int sizeZ, double scaleX, double scaleY, double scaleZ) {
        return new double[sizeX * sizeY * sizeZ];
    }
}
