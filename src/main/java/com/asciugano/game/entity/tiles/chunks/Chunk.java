package com.asciugano.game.entity.tiles.chunks;

import java.util.Random;

import com.asciugano.engine.models.ColoredModel;
import com.asciugano.engine.models.MeshBuilder;
import com.asciugano.engine.renderer.Loader;
import com.asciugano.engine.utils.Color;
import com.asciugano.game.entity.tiles.DirtTile;
import com.asciugano.game.entity.tiles.GrassTile;
import com.asciugano.game.entity.tiles.PathTile;
import com.asciugano.game.entity.tiles.SoilTile;
import com.asciugano.game.entity.tiles.TerrainTile;
import com.asciugano.game.entity.tiles.Tile;

public class Chunk {

  private static final int SIZE = 16;

  public static int getSize() {
    return SIZE;
  }

  private TerrainTile tiles[][];

  private int x, z;

  public Chunk(int x, int z) {
    this.x = x;
    this.z = z;
  }

  public void loadTiles() {
    // TODO: implementare dopo salvataggi
  }

  public void generateTiles(Loader loader) {
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
      }
    }
  }

  public TerrainTile getTile(int x, int z) {
    return tiles[x][z];
  }

  public TerrainTile[][] getTiles() {
    return tiles;
  }

  public int getX() {
    return x;
  }

  public int getZ() {
    return z;
  }
}
