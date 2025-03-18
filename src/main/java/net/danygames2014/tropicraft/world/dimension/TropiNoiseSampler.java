package net.danygames2014.tropicraft.world.dimension;

import net.minecraft.util.math.noise.NoiseSampler;
import net.minecraft.util.math.noise.PerlinNoiseSampler;

import java.util.Arrays;
import java.util.Random;

public class TropiNoiseSampler extends NoiseSampler {
    private final PerlinNoiseSampler[] octaveSamplers;
    private final int octaves;

    public TropiNoiseSampler(Random random, int octaves) {
        this.octaves = octaves;
        this.octaveSamplers = new PerlinNoiseSampler[octaves];

        for (int octave = 0; octave < octaves; octave++) {
            this.octaveSamplers[octave] = new PerlinNoiseSampler(random);
        }
    }

    public double samplePoint(double x, double z, double scaleX, double scaleZ) {
        return this.sample(null, x, z, 1, 1, scaleX, scaleZ)[0];
    }

    public double[] sample(double[] map, double x, double z, int sizeX, int sizeZ, double scaleX, double scaleZ) {
        return this.sample(map, x, 10.0F, z, sizeX, sizeZ, scaleX, scaleZ);
    }

    public double[] sample(double[] map, double x, double y, double z, int sizeX, int sizeZ, double scaleX, double scaleZ) {
        if (map == null) {
            map = new double[sizeX * sizeZ];
        } else {
            Arrays.fill(map, 0.0D);
        }

        double scaleMulitplier = 1.0D;

        for (int octave = 0; octave < this.octaves; octave++) {
            this.octaveSamplers[octave].create(map, x, y, z, sizeX, 1, sizeZ, scaleX * scaleMulitplier, 1.0F, scaleZ * scaleMulitplier, scaleMulitplier);
            scaleMulitplier /= 2.0D;
        }

        return map;
    }
}
