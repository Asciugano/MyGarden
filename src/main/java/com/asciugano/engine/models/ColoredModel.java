package com.asciugano.engine.models;

import com.asciugano.engine.renderer.Loader;
import com.asciugano.engine.utils.Color;
import org.joml.Vector3f;

public class ColoredModel {
    private RawModel model;
    private Color color;

    public ColoredModel(float[] vertices, float[] normals, float[] colors, int[] indices) {
        Loader loader = new Loader();
        model = loader.loadToVAO(vertices, normals, colors, indices);
        color = new Color(new Vector3f(0, 0, 0));
    }

    public RawModel getRawModel() { return model; }
    public Color getColor() { return color; }
}
