#version 400 core

in vec2 textureCoords;
in vec3 passColor;

out vec4 outColor;

uniform sampler2D uiTexture;

void main() {
    outColor = vec4(passColor, 1);
//    outColor = texture(uiTexture, textureCoords);
}