package Helpers;

import java.util.Random;

public class Rand extends Random {
    public Integer NextInt(int min, int max) {
        return nextInt((max - min) + 1) + min;
    }

    public Double NextDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }

    public Boolean NextBool() {
        return nextBoolean();
    }
}
