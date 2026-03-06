package com.asciugano.engine.entities;

import com.asciugano.engine.models.TexturedModel;
import org.joml.Vector3f;

public class Entity {
    private TexturedModel model;

    private Vector3f position;
    private Vector3f rotation;
    private float scale;

    public Entity(
            TexturedModel model,
            Vector3f postion,
            Vector3f rotation,
            float scale
    ) {
        this.model = model;
        this.position = postion;
        this.rotation = rotation;
        this.scale = scale;
    }

    public TexturedModel getModel() { return model; }
}
