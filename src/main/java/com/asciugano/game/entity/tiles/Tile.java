package com.asciugano.game.entity.tiles;

import com.asciugano.engine.models.TexturedModel;
import com.asciugano.engine.renderer.Loader;
import com.asciugano.engine.terrains.Terrain;
import com.asciugano.engine.textures.ModelTexture;
import org.joml.Vector3f;

public class Tile {
    private static final int TILE_SIZE = 4;
    public static int getTileSize() { return TILE_SIZE; }

    private int gridX, gridZ;
    private TileType tileType;
    private TexturedModel model;

    public Tile(Loader loader, TileType tileType, float x, float z, int gridX, int gridZ) {
        this.gridX = (int) (x / Tile.getTileSize() + ((float) (Terrain.getSize() * TILE_SIZE) / 2));
        this.gridZ = (int) (x / Tile.getTileSize() + ((float) (Terrain.getSize() * TILE_SIZE) / 2));
        this.tileType = tileType;

        createModel(loader);
    }

    public Tile(Loader loader, TileType tileType, int gridX, int gridZ) {
        this.gridX = gridX;
        this.gridZ = gridZ;
        this.tileType = tileType;

        createModel(loader);
    }

    private void createModel(Loader loader) {
        float[] vertices = {
                0, 0, 0,
                0, 0, 1,
                1, 0, 1,
                1, 0, 0
        };

        float[] textureCoords = {
                0, 0, 0, 1, 1, 1, 1, 0
        };

        int[] indices = { 0, 1, 2, 2, 3, 0 };
        float[] normals = {
                0, 1, 0,
                0, 1, 0,
                0, 1, 0,
                0, 1, 0,
        };

        model = new TexturedModel(
                loader.loadToVAO(
                        vertices, normals, textureCoords,  indices),
                new ModelTexture( loader.loadTexture(tileType.getTextureName()))
        );
    }

    protected void onClick() {
        System.out.println("click the tile: " + gridX + ", " + gridZ);
    }

    public int getGridX() { return gridX; }

    public void setGridX(int gridX) { this.gridX = gridX; }

    public int getGridZ() { return gridZ; }

    public void setGridZ(int gridZ) { this.gridZ = gridZ; }

    public Vector3f getWorldPos() {
        return new Vector3f(this.gridX * TILE_SIZE + Terrain.getSize() * TILE_SIZE, 0, this.gridZ * TILE_SIZE + Terrain.getSize() * TILE_SIZE);
    }

    public TexturedModel getModel() { return model; }
}
