package com.asciugano.engine.components;

public class ComponentType {
    public final String name;
    public boolean isActive;

    public ComponentType(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    protected void setIsActive(boolean isActive) { this.isActive = isActive; }
}
