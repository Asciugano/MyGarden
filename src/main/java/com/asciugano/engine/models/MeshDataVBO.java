package com.asciugano.engine.models;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_DYNAMIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glBufferSubData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.nio.ByteBuffer;

public class MeshDataVBO {

  private int vboID;
  private long capacity;

  public MeshDataVBO(long initialCapacity) {
    this.capacity = initialCapacity;

    vboID = glGenBuffers();
    glBindBuffer(GL_ARRAY_BUFFER, vboID);
    glBufferData(GL_ARRAY_BUFFER, capacity, GL_DYNAMIC_DRAW);
  }

  /**
   * Aggiorna i dati nel VBO a partire da offset.
   */
  public void updateData(long offset, ByteBuffer data) {
    glBindBuffer(GL_ARRAY_BUFFER, vboID);
    glBufferSubData(GL_ARRAY_BUFFER, offset, data);
  }

  /**
   * Ridimensiona il VBO creando un nuovo buffer e copiando i dati esistenti
   * manualmente.
   */
  public void resize(int currentSize, long newCapacity) {
    int newVboID = glGenBuffers();
    glBindBuffer(GL_ARRAY_BUFFER, newVboID);
    glBufferData(GL_ARRAY_BUFFER, newCapacity, GL_DYNAMIC_DRAW);

    glDeleteBuffers(vboID);
    vboID = newVboID;
    capacity = newCapacity;
  }

  public long getCapacity() {
    return capacity;
  }

  public int getId() {
    return vboID;
  }
}
