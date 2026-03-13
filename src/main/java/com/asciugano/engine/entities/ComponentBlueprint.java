package com.asciugano.engine.entities;

import com.asciugano.engine.components.Component;
import com.asciugano.engine.components.ComponentType;

public abstract class ComponentBlueprint<T extends Component> {
    public final ComponentType type;

    public ComponentBlueprint(ComponentType type) {
        this.type = type;
    }

    public abstract ComponentBlueprint create(Entity entity, ComponentParams... params);
}
