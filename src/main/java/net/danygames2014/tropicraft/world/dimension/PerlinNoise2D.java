package net.danygames2014.tropicraft.world.dimension;

import java.util.Random;

public class PerlinNoise2D {
    private final int[] p = new int[512];

    private final int octaves;
    private final double persistence;
    private final double lacunarity;

    public PerlinNoise2D(long seed, int octaves, double persistence, double lacunarity) {
        this.octaves = octaves;
        this.persistence = persistence;
        this.lacunarity = lacunarity;

        Random rand = new Random(seed);
        int[] permutation = new int[256];
        for (int i = 0; i < 256; i++) {
            permutation[i] = i;
        }

        // Shuffle the array
        for (int i = 0; i < 256; i++) {
            int swapIndex = rand.nextInt(256 - i) + i;
            int temp = permutation[i];
            permutation[i] = permutation[swapIndex];
            permutation[swapIndex] = temp;
        }

        // Copy the permutation twice for wrapping/boundary-less indexing
        for (int i = 0; i < 256; i++) {
            p[i] = permutation[i];
            p[i + 256] = permutation[i];
        }
    }

    public double sample(double x, double z, double scaleX, double scaleZ) {
        return sample(x * scaleX, z * scaleZ);
    }

    public double sample(double x, double z) {
        double value = 0;
        double frequency = 1;
        double amplitude = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            value += noise(x * frequency, z * frequency) * amplitude;

            maxValue += amplitude;
            frequency *= lacunarity;
            amplitude *= persistence;
        }

        // Normalize and return
        return value / maxValue;
    }

    public void sampleArray(double[][] noiseArray, double scaleX, double scaleZ) {
        int height = noiseArray.length;
        if (height == 0) return; // Handle empty array
        int width = noiseArray[0].length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Query the noise using scaled coordinates
                noiseArray[y][x] = sample(x, y, scaleX, scaleZ);
            }
        }
    }

    private double noise(double x, double y) {
        int X = (int) Math.floor(x) & 255;
        int Y = (int) Math.floor(y) & 255;

        x -= Math.floor(x);
        y -= Math.floor(y);

        double u = fade(x);
        double v = fade(y);

        int A = p[X] + Y;
        int B = p[X + 1] + Y;

        // Interpolation along X
        double n0 = grad(p[A], x, y);
        double n1 = grad(p[B], x - 1, y);
        double i1 = lerp(u, n0, n1);

        // Interpolation along X (at y+1)
        n0 = grad(p[A + 1], x, y - 1);
        n1 = grad(p[B + 1], x - 1, y - 1);
        double i2 = lerp(u, n0, n1);

        // Final Interpolation along Y
        return lerp(v, i1, i2);
    }

    private double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    private double grad(int hash, double x, double y) {
        int h = hash & 7;
        double u = h < 4 ? x : y;
        double v = h < 4 ? y : x;

        return switch (h) {
            case 0 -> x + y;
            case 1 -> -x + y;
            case 2 -> x - y;
            case 3 -> -x - y;
            case 4 -> u + v;
            case 5 -> -u + v;
            case 6 -> u - v;
            case 7 -> -u - v;
            default -> 0;
        };
    }
}