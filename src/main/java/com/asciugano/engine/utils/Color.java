package com.asciugano.engine.utils;

import org.joml.Vector3f;

public class Color {
    private float  red;
    private float green;
    private float blue;

    public Color(float red, float green, float blue) {
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    public Color(int red, int green, int blue) {
        this.red = clamp(red / 255f);
        this.green = clamp(green / 255f);
        this.blue = clamp(blue / 255f);
    }

    public Color(Vector3f color) {
        this.red = color.x;
        this.green = color.y;
        this.blue = color.z;
    }

    public Color(String hex) {
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

        this.red = rInt / 255f;
        this.green = gInt / 255f;
        this.blue = bInt / 255f;
    }

    private float clamp(float value) { return Math.max(0, Math.min(1, value)); }

    public Vector3f getColor() { return new Vector3f(red, green, blue); }
}
