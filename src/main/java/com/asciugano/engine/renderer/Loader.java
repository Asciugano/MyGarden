package com.asciugano.engine.renderer;

import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.*;

public class Loader {

    private List<Integer> vaos = new ArrayList<>();
    private List<Integer> vbos = new ArrayList<>();

    public RawModel loadToVAO(float[] position, int[] indices) {
        int vaoID = createVAO();
        bindIndicesBuffer(indices);
        storeDataInAttributeList(0, 3, position);
        unbindVAO();

        return new RawModel(vaoID, indices.length);
    }

    private int createVAO() {
        int vaoID = glGenVertexArrays();
        vaos.add(vaoID);

        glBindVertexArray(vaoID);

        return vaoID;
    }

    private void storeDataInAttributeList(int attributeNumber, int attribSize, float[] data) {
        int vboID = glGenBuffers();
        vbos.add(vboID);

        glBindBuffer(GL_ARRAY_BUFFER, vboID);

        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data).flip();

        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);

        glVertexAttribPointer(attributeNumber, attribSize, GL_FLOAT, false, 0, 0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        MemoryUtil.memFree(buffer);
    }

    private void bindIndicesBuffer(int[] indices) {
        int vboID = glGenBuffers();
        vbos.add(vboID);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboID);

        IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
        buffer.put(indices).flip();

        glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);

        MemoryUtil.memFree(buffer);
    }

    private void unbindVAO() {
        glBindVertexArray(0);
    }

    public void cleanUp() {
        for(int vao : vaos) glDeleteVertexArrays(vao);
        for(int vbo : vbos) glDeleteBuffers(vbo);
    }
}
