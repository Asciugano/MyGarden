package com.asciugano.engine.entities;

import com.asciugano.engine.components.ComponentType;

public class ComponentParams {
    public final ComponentType type;
    public final Object data;

    public ComponentParams(ComponentType type, Object data) {
        this.type = type;
        this.data = data;
    }
}
