package com.asciugano.game;

import com.asciugano.engine.entities.Blueprint;

import java.util.HashMap;
import java.util.Map;

public class BlueprintRepository {
    private final Map<String, Blueprint> blueprints = new HashMap<>();

    public void register(Blueprint blueprint) { blueprints.put(blueprint.id, blueprint); }

    public Blueprint getBlueprint(String id) {
        Blueprint blueprint = blueprints.get(id);

        if(blueprint == null) {
            System.out.println("Blueprint not found");
            throw new RuntimeException("Blueprint not found");
        }

        return blueprint;
    }
}
