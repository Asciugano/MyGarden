package com.asciugano.engine.models;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.nio.ByteBuffer;

public class MeshData {

  public static final int BYTES_PER_VERTEX = 36; // INFO: si puo' cambiare

  private final MeshDataVBO meshDataVBO;
  private int vaoID;
  private int vertexCount;

  public MeshData(long initialCapacity) {
    vaoID = glGenVertexArrays();
    glBindVertexArray(vaoID);

    this.meshDataVBO = new MeshDataVBO(initialCapacity);

    glBindBuffer(GL_ARRAY_BUFFER, meshDataVBO.getId());

    glVertexAttribPointer(0, 3, GL_FLOAT, false, BYTES_PER_VERTEX, 0);
    glVertexAttribPointer(1, 3, GL_FLOAT, false, BYTES_PER_VERTEX, 3 * Float.BYTES);
    glVertexAttribPointer(2, 3, GL_FLOAT, false, BYTES_PER_VERTEX, 6 * Float.BYTES);

    glBindVertexArray(0);
  }

  public MeshDataVBO getMeshDataVBO() {
    return meshDataVBO;
  }

  public long getVBOCapacity() {
    return meshDataVBO.getCapacity();
  }

  public void updateData(long offset, ByteBuffer buffer) {
    meshDataVBO.updateData(offset, buffer);
  }

  public void setVertexCount(int count) {
    this.vertexCount = count;
  }

  public int getVertexCount() {
    return this.vertexCount;
  }

  public int getVaoID() {
    return vaoID;
  }

  public void setVaoID(int vaoID) {
    this.vaoID = vaoID;
  }
}
