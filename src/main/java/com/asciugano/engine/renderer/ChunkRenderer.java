package com.asciugano.engine.renderer;

import static org.lwjgl.opengl.GL11.GL_FLAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

import java.util.List;

import org.joml.Matrix4f;

import com.asciugano.engine.models.MeshData;
import com.asciugano.engine.shaders.TileShader;

public class ChunkRenderer {

  private TileShader shader;

  public ChunkRenderer(TileShader shader, Matrix4f projectionMatrix) {
    this.shader = shader;
    this.shader.start();
    this.shader.loadProjectionMatrix(projectionMatrix);
    this.shader.stop();
  }

  public void render(List<MeshData> meshes) {
    for (MeshData mesh : meshes) {
      glBindBuffer(GL_ARRAY_BUFFER, mesh.getMeshDataVBO().getId());

      glEnableVertexAttribArray(0);
      glVertexAttribPointer(0, 3, GL_FLAT, false, 3 * Float.BYTES, 0);

      glDrawArrays(GL_TRIANGLES, 0, mesh.getVertexCount());

      glDisableVertexAttribArray(0);
    }
  }
}
