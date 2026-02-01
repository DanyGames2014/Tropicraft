package net.danygames2014.tropicraft.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class Spline {
    private final ObjectArrayList<Point> points = new ObjectArrayList<>();

    public void addPoint(float location, float value) {
        points.add(new Point(location, value));
        points.sort((a, b) -> Float.compare(a.location, b.location));
    }

    public float sample(float noiseValue) {
        if (points.isEmpty()) return 0;
        if (noiseValue <= points.get(0).location) return points.get(0).value;
        if (noiseValue >= points.get(points.size() - 1).location) return points.get(points.size() - 1).value;

        // Find the segment containing the noiseValue
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);

            if (noiseValue >= p1.location && noiseValue <= p2.location) {
                // Linear interpolation (Lerp)
                float t = (noiseValue - p1.location) / (p2.location - p1.location);
                return p1.value + t * (p2.value - p1.value);
            }
        }
        return 0;
    }

    private static class Point {
        float location; // Noise value (e.g., -1.0 to 1.0)
        float value;    // Resulting height/factor

        public Point(float loc, float val) {
            this.location = loc;
            this.value = val;
        }
    }
}
