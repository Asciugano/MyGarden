package com.asciugano.engine.components;

import com.asciugano.engine.entities.ComponentBundle;
import com.asciugano.engine.entities.Entity;
import org.joml.Vector3f;

public class EntityTransform extends Component {
    private Entity entity;
    private Vector3f position;
    private Vector3f rotation;
    private float scale;

    public EntityTransform() {
        super(new ComponentType("EntityTransform", true));
        this.entity = null;
        this.position = new Vector3f(0, 0, 0);
        this.rotation = new Vector3f(0, 0, 0);
        this.scale = 1;
    }

    public EntityTransform(Vector3f position) {
        super(new ComponentType("EntityTransform", true));
        this.entity = null;
        this.position = position;
        this.rotation = new Vector3f(0, 0, 0);
        this.scale = 1;
    }

    public Vector3f getPosition() { return position; }

    public Vector3f getRotation() { return rotation; }

    public float getScale() { return scale; }

    public void setEntity(Entity entity) { this.entity = entity; }
}
