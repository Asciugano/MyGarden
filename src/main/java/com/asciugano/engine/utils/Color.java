package com.asciugano.engine.utils;

import org.joml.Vector3f;

public class Color {
    public final Vector3f color;
    public Color(Vector3f color) {
        this.color = color;
    }

    public static Vector3f fromFloat(float red, float green, float blue) {
        return new Vector3f(clamp(red), clamp(green), clamp(blue));
    }

    public static Vector3f fromInt(int red, int green, int blue) {
        return new Vector3f(clamp(red / 255f), clamp(green / 255f), clamp(blue / 255f));
    }

    public static Vector3f hex(String hex) {
        if(hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        if(hex.length() != 6) {
            throw new IllegalArgumentException("Hex must by 6 chars");
        }

        int intValue = Integer.parseInt(hex, 16);
        int rInt = (intValue >> 16) & 0xFF;
        int gInt = (intValue >> 8) & 0xFF;
        int bInt = intValue & 0xFF;

        return fromInt(rInt, gInt, bInt);
    }

    public static final Vector3f WHITE = new Vector3f(1, 1, 1);
    public static final Vector3f BLACK = new Vector3f(0, 0, 0);

    private static float clamp(float value) { return Math.max(0, Math.min(1, value)); }
}
