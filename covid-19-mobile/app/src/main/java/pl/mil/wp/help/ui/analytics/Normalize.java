package pl.mil.wp.help.ui.analytics;

public class Normalize {
    public static float normalize(float value, float min, float max, int newMin, int newMax) {
        return ((value - min) / (max - min)) * (newMax - newMin) + newMin;
    }
}

