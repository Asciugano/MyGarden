package com.asciugano.game.entity.tiles.chunks;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import com.asciugano.engine.terrains.Terrain;
import com.asciugano.game.entity.tiles.TerrainTile;

public class ChunkMeshBuilder {

  public static ByteBuffer build(Chunk chunk) {
    List<Float> vertices = new ArrayList<>();

    TerrainTile[][] tiles = chunk.getTiles();
    int size = Chunk.getSize();

    for (int x = 0; x < size; x++) {
      for (int z = 0; z < size; z++) {
        TerrainTile tile = tiles[x][z];
        addTileQuad(vertices, tile, chunk);
      }
    }

    return toByteBuffer(vertices);
  }

  private static void addTileQuad(List<Float> vertices, TerrainTile tile, Chunk chunk) {
    Vector3f position = Terrain.getPositionFromGrid(tile.getGridX(), tile.getGridZ(), chunk.getX(), chunk.getZ());
    position.y = tile.getEdgeHeight();

    vertices.add(position.x);
    vertices.add(position.y);
    vertices.add(position.z);
    vertices.add(position.x + 1);
    vertices.add(position.y);
    vertices.add(position.z);
    vertices.add(position.x + 1);
    vertices.add(position.y);
    vertices.add(position.z + 1);

    vertices.add(position.x);
    vertices.add(position.y);
    vertices.add(position.z);
    vertices.add(position.x + 1);
    vertices.add(position.y);
    vertices.add(position.z + 1);
    vertices.add(position.x);
    vertices.add(position.y);
    vertices.add(position.z + 1);
  }

  private static ByteBuffer toByteBuffer(List<Float> data) {
    ByteBuffer buffer = BufferUtils.createByteBuffer(data.size() * Float.BYTES);
    for (float f : data)
      buffer.putFloat(f);

    return buffer.flip();
  }
}
