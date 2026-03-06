#version 400 core

in vec2 pass_textureCoords;
out vec4 outColor;

uniform sampler2D textureSampler;

void main() {
//    outColor = vec4(color, 1);
    outColor = texture(textureSampler, pass_textureCoords);
}