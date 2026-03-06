package com.asciugano.engine.shaders;

import org.joml.Matrix4f;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

public class StaticShader extends ShaderProgram {

    private static final String PATH = "src/main/resources/shaders/";

    private static final String VERTEX_FILE = PATH + "vertexShader.glsl";
    private static final String FRAGMENT_FILE = PATH + "fragmentShader.glsl";

    private int location_transformationMatrix;
    private int location_projectionMatrix;
    private int location_viewMatrix;

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        bindAttribute(0, "position");
        bindAttribute(1, "textureCoords");
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = glGetUniformLocation(getProgramID(), "transformationMatrix");
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        float[] buffer = new float[16];
        matrix.get(buffer);

        glUniformMatrix4fv(
                location_transformationMatrix,
                false,
                buffer
        );
    }

    public int getProgramID() {
        return super.getProgramID();
    }
}
