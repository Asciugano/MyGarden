package com.asciugano.game.scene;

import com.asciugano.engine.components.EntityTransform;
import com.asciugano.engine.entities.Blueprint;
import com.asciugano.engine.entities.Entity;
import com.asciugano.game.GameManager;
import org.joml.Vector3f;

public class SceneLayout {
    public static void addEntitiesToScene(Scene scene) {
        Blueprint blueprint = GameManager.getRepository().getBlueprint("house");

        Entity entity1 = blueprint.createInstance(scene, new EntityTransform(new Vector3f(16, 0, 2)));
        Entity entity2 = blueprint.createInstance(scene, new EntityTransform(new Vector3f(15, 0, 23)));
        Entity entity3 = blueprint.createInstance(scene, new EntityTransform(new Vector3f(1, 0, 2)));
    }
}
