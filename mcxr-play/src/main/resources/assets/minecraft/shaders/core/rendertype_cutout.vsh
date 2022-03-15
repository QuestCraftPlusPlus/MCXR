#version 100

#moj_import <light.glsl>

attribute vec3 Position;
attribute vec4 Color;
attribute vec2 UV0;
attribute vec2 UV2;
attribute vec3 Normal;

uniform sampler2D Sampler2;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform vec3 ChunkOffset;

varying float vertexDistance;
varying vec4 vertexColor;
varying vec2 texCoord0;
varying vec4 normal;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position + ChunkOffset, 1.0);

    vertexDistance = length((ModelViewMat * vec4(Position + ChunkOffset, 1.0)).xyz);
    vertexColor = Color * minecraft_sample_lightmap(Sampler2, floor(UV2));
    texCoord0 = UV0;
    normal = ProjMat * ModelViewMat * vec4(Normal, 0.0);
}