package net.danygames2014.tropicraft.util;

import java.util.Arrays;

public class Spline {
    private float[] locations = new float[0];
    private float[] values = new float[0];
    private int size = 0;

    public void addPoint(float location, float value) {
        // Ensure capacity
        if (size >= locations.length) {
            locations = Arrays.copyOf(locations, locations.length + 1);
            values = Arrays.copyOf(values, values.length + 1);
        }

        // Find insertion point
        int i = size - 1;
        while (i >= 0 && locations[i] > location) {
            locations[i + 1] = locations[i];
            values[i + 1] = values[i];
            i--;
        }

        locations[i + 1] = location;
        values[i + 1] = value;
        size++;
    }

    public float sample(float noiseValue) {
        // 1. Quick Guard Clauses
        if (size == 0) return 0;
        float firstLoc = locations[0];
        if (noiseValue <= firstLoc) return values[0];

        float lastLoc = locations[size - 1];
        if (noiseValue >= lastLoc) return values[size - 1];

        // 2. Linear Search (Fastest for N <= 16 due to cache locality)
        // We start from index 1 because we already checked index 0
        for (int i = 1; i < size; i++) {
            float currLoc = locations[i];

            if (noiseValue < currLoc) {
                float prevLoc = locations[i - 1];
                float prevVal = values[i - 1];
                float currVal = values[i];

                // 3. Linear Interpolation (Lerp)
                // t = (x - x0) / (x1 - x0)
                float t = (noiseValue - prevLoc) / (currLoc - prevLoc);
                return prevVal + t * (currVal - prevVal);
            }
        }

        return values[size - 1];
    }
}
