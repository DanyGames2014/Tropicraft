package net.danygames2014.tropicraft.util;

public class MathHelper {
    public static double clamp(double value, double min, double max) {
        if (value > max) {
            return max;
        }

        if (value < min) {
            return min;
        }

        return value;
    }

    public static float cycleClampUp(float value, float add, float max) {
        value += add;
        if (value > max) {
            return value - max;
        }
        return value;
    }

    public static float pushBack(float value, float min, float max, float amount) {
        if (value < min) {
            return value + amount;
        }

        if (value > max) {
            return value - amount;
        }

        return value;
    }

    public static float pushBack(float value, float min, float max) {
        return pushBack(value, min, max, 1.0F);
    }

    public static double distance(int x1, int y1, int z1, int x2, int y2, int z2) {
        int x = x1 - x2;
        int y = y1 - y2;
        int z = z1 - z2;
        return Math.sqrt(x * x + y * y + z * z);
    }
}
