package com.asciugano.engine.terrains;

import com.asciugano.engine.renderer.Loader;
import com.asciugano.game.entity.tiles.*;

import java.util.Random;

import org.joml.Vector3f;

public class Terrain {
  private static final int SIZE = 32;

  public static int getSize() {
    return SIZE;
  }

  private static final TerrainTile[][] tiles = new TerrainTile[SIZE][SIZE];

  public Terrain(Loader loader) {
    generateTerrain(loader);
  }

  private void loadFromFile() {
    // TODO: implementare dopo al salvataggio
  }

  public void generateTerrain(Loader loader) {
    for (int x = 0; x < SIZE; x++) {
      for (int z = 0; z < SIZE; z++) {
        Random random = new Random();
        int typeN = random.nextInt(4);
        TerrainTile tile;

        switch (typeN) {
          case 0 -> tile = new PathTile(new Tile(x, z), loader);
          case 1 -> tile = new GrassTile(new Tile(x, z), loader);
          case 2 -> tile = new SoilTile(new Tile(x, z), loader);
          case 3 -> tile = new DirtTile(new Tile(x, z), loader);

          default -> tile = new GrassTile(new Tile(x, z), loader);
        }

        tiles[x][z] = tile;
        System.out.println("pos: " + tiles[x][z].getWorldPos());
      }
    }
  }

  public static Vector3f getPositionFromGrid(int x, int z) {
    return new Vector3f(x * Tile.getTileSize() - (float) SIZE / 2, 0, z * Tile.getTileSize() - (float) SIZE / 2);
  }

  public static TerrainTile getTileFromWorld(float x, float z) {
    int gridX = (int) Math.floor((x + offset(x, z)) / Tile.getTileSize());
    int gridZ = (int) Math.floor((z + offset(x, z)) / Tile.getTileSize());

    if (gridX < 0 || gridZ < 0 || gridX >= SIZE || gridZ >= SIZE)
      return null;

    return tiles[gridX][gridZ];
  }

  public TerrainTile[][] getTiles() {
    return tiles;
  }

  public static float offset(float x, float z) {
    return (SIZE * Tile.getTileSize()) / 2f;
  }
}
