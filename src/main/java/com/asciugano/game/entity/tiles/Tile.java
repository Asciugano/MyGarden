package com.asciugano.game.entity.tiles;

import com.asciugano.engine.models.TexturedModel;
import com.asciugano.engine.renderer.Loader;
import com.asciugano.engine.terrains.Terrain;
import com.asciugano.engine.textures.ModelTexture;
import org.joml.Vector3f;

public class Tile {
    protected int gridX, gridZ;
    protected static final int TILE_SIZE = 4;
    public static int getTileSize() { return TILE_SIZE; }

    public Tile(int gridX, int gridZ) {
        this.gridX = gridX;
        this.gridZ = gridZ;
    }

    public int getGridX() { return gridX; }
    public int getGridZ() { return gridZ; }
    public Vector3f getWorldPos() {
        float offset = TILE_SIZE / 2f;
        return new Vector3f((gridX - offset) * TILE_SIZE, 0, (gridZ - offset) * TILE_SIZE);
    }
}
