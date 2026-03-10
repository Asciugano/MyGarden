package com.asciugano.game;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<Terrain> terrains = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void addTerrain(Terrain terrain) {
        this.terrains.add(terrain);
    }
}
