package com.asciugano.engine.renderer;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

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
      prepareModel(mesh);
      // prepareInstance(mesh);

      glDrawArrays(GL_TRIANGLES, 0, mesh.getVertexCount());

      unbindModel();
    }
  }

  private void prepareModel(MeshData mesh) {
    glBindVertexArray(mesh.getVaoID());

    glEnableVertexAttribArray(0);
    glEnableVertexAttribArray(1);
    glEnableVertexAttribArray(2);
  }

  private void unbindModel() {
    glDisableVertexAttribArray(0);
    glDisableVertexAttribArray(1);
    glDisableVertexAttribArray(2);

    glBindVertexArray(0);
  }
}
