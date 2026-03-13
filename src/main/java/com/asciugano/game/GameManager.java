package com.asciugano.game;

import com.asciugano.engine.entities.Blueprint;

public class GameManager {
    private static BlueprintRepository blueprintRepository = new BlueprintRepository();

    public static BlueprintRepository getRepository() { return blueprintRepository; }
}
