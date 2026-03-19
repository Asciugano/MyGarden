package com.asciugano.engine.models;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_DYNAMIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glBufferSubData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL31.GL_COPY_READ_BUFFER;
import static org.lwjgl.opengl.GL31.GL_COPY_WRITE_BUFFER;
import static org.lwjgl.opengl.GL31.glCopyBufferSubData;

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

  public void updateData(long offset, ByteBuffer data) {
    glBindBuffer(GL_ARRAY_BUFFER, vboID);
    glBufferSubData(GL_ARRAY_BUFFER, offset, data);
  }

  public void resize(int currentSize, long newCapacity) {
    int newVbo = glGenBuffers();

    glBindBuffer(GL_COPY_READ_BUFFER, vboID);

    glBindBuffer(GL_COPY_WRITE_BUFFER, newVbo);
    glBufferData(GL_COPY_WRITE_BUFFER, newCapacity, GL_DYNAMIC_DRAW);

    glCopyBufferSubData(
        GL_COPY_READ_BUFFER,
        GL_COPY_WRITE_BUFFER,
        0,
        0,
        currentSize);

    glDeleteBuffers(vboID);

    vboID = newVbo;
    capacity = newCapacity;
  }

  public long getCapacity() {
    return capacity;
  }

  public int getId() {
    return vboID;
  }
}
