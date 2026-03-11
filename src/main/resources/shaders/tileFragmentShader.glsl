#version 400 core

in vec2 pass_textureCoords;
out vec4 outColor;

uniform sampler2D textureSampler;

void main() {
    vec4 textureColor = texture(textureSampler, pass_textureCoords);
    outColor = textureColor;
}