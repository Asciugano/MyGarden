package com.asciugano.engine.shaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

public abstract class ShaderProgram {

    private int programID;
    private int vertexShaderID;
    private int fragmentShaderID;

    public ShaderProgram(String vertexFile, String fragmentFile) {
        vertexShaderID = loadShader(vertexFile, GL_VERTEX_SHADER);
        fragmentShaderID = loadShader(fragmentFile, GL_FRAGMENT_SHADER);

        programID = glCreateProgram();
        glAttachShader(programID, vertexShaderID);
        glAttachShader(programID, fragmentShaderID);

        bindAttributes();

        glLinkProgram(programID);
        glValidateProgram(programID);

        getAllUniformLocations();
    }

    protected abstract void bindAttributes();

    protected abstract void getAllUniformLocations();

protected void bindAttribute(int attribute, String variableName) {
    glBindAttribLocation(programID, attribute, variableName);
}

public void start() {
    glUseProgram(programID);
}

public void stop() {
    glUseProgram(0);
}

public void cleanUp() {
    stop();

    glDetachShader(programID, vertexShaderID);
    glDetachShader(programID, fragmentShaderID);

    glDeleteShader(vertexShaderID);
    glDeleteShader(fragmentShaderID);

    glDeleteShader(programID);
}

    private static int loadShader(String file, int type) {
        StringBuilder shaderSource = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                shaderSource.append(line).append("\n");
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error while reading shader file");
            throw new RuntimeException(e);
        }

        int shaderID = glCreateShader(type);
        glShaderSource(shaderID, shaderSource);
        glCompileShader(shaderID);

        if(glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE) {
            System.out.println("Could not compile the shader: " + glGetShaderInfoLog(shaderID));
            throw new RuntimeException("Shader compilation failed: " + glGetShaderInfoLog(shaderID));
        }

        return shaderID;
    }

    protected int getProgramID() { return programID; }
}
