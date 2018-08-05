package org.kd.lib.general;

public class Numbers {

    public static double getMax(double[] array) {
        double max = -Double.MAX_VALUE;
        for (Double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static double getMin(double[] array) {
        double min = Float.MAX_VALUE;
        for (Double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
