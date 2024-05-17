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
}
