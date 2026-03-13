package com.asciugano.engine.entities;

import com.asciugano.engine.components.Component;
import com.asciugano.engine.components.ComponentType;

import java.util.HashMap;
import java.util.Map;

public class ComponentBundle {
    private final Map<ComponentType, Component> components = new HashMap<>();
    private final Map<ComponentType, ComponentParams> params = new HashMap<>();

    public ComponentBundle(ComponentParams... paramList) {
        for(ComponentParams param : paramList) {
            params.put(param.type, param);
        }
    }

    public void addComponent(Component component) {
        components.put(component.type, component);
    }

    public void addComponents(Map<ComponentType, Component> components) {
        this.components.putAll(components);
    }

    public Map<ComponentType, Component> getComponents() { return components; }

    public ComponentParams getParams(ComponentType type) { return params.get(type); }
}
