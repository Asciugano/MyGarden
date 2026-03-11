#version 400 core

in vec2 position;

out vec2 textureCoords;
out vec3 passColor;

uniform mat4 transformationMatrix;
uniform vec3 color;

void main() {
    gl_Position = transformationMatrix * vec4(position, 0, 1);
    textureCoords = vec2((position.x + 1) / 2, 1 -  (position.y + 1) / 2);
    passColor = color;
}