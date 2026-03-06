package com.asciugano.engine.renderer;

import com.asciugano.engine.shaders.StaticShader;
import org.joml.Matrix4f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.GL_TRANSFORM_FEEDBACK_BUFFER_MODE;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Renderer {

    public void render(RawModel model) {
        glBindVertexArray(model.getVaoID());
        glEnableVertexAttribArray(0);

        glDrawElements(GL_TRIANGLES, model.getVertexCount(), GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glBindVertexArray(0);
    }
}
