package com.asciugano.engine.terrains;

import com.asciugano.engine.renderer.Loader;
import com.asciugano.game.entity.tiles.GrassTile;
import com.asciugano.game.entity.tiles.TerrainTile;
import com.asciugano.game.entity.tiles.Tile;
import com.asciugano.game.entity.tiles.TileType;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Terrain {
    private static final int SIZE = 32;
    public static int getSize() { return SIZE; }

    private static final TerrainTile[][] tiles =  new TerrainTile[SIZE][SIZE];
    private Map<TileType, List<Vector3f>> tilesPerType = new HashMap<>();

    public Terrain(Loader loader) {
        generateTerrain(loader);
    }

    private void loadFromFile() {
        // TODO: implementare dopo al salvataggio
    }

    public void generateTerrain(Loader loader) {
        float offset = (float) (SIZE * Tile.getTileSize()) / 2;

        for(int x = 0; x < SIZE; x++) {
            for(int z = 0; z < SIZE; z++) {
                TileType type = TileType.GRASS_TYPE;
                if((x + z) % 2 == 0)
                    type = TileType.PATH_TYPE;

                float worldX = x * Tile.getTileSize() - offset;
                float worldZ = z * Tile.getTileSize() - offset;
                tiles[x][z] = new GrassTile(new Tile(x, z));
            }
        }
    }

    public static Vector3f getPositionFromGrid(int x, int z) {
        return new Vector3f(x * Tile.getTileSize() - (float) SIZE / 2, 0, z * Tile.getTileSize() - (float) SIZE / 2);
    }

    public static TerrainTile getTileFromWorld(float x, float z) {
        int gridX = (int) Math.floor(x / Tile.getTileSize() + SIZE / 2f);
        int gridZ = (int) Math.floor(z / Tile.getTileSize() + SIZE / 2f);

        if(gridX < 0 || gridZ < 0 || gridX >= SIZE || gridZ >= SIZE) {
            return null;
        }

        return tiles[gridX][gridZ];
    }

    public TerrainTile[][] getTiles() { return tiles; }
}
