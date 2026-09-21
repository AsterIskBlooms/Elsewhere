#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>

uniform sampler2D Sampler0;

in float sphericalVertexDistance;
in float cylindricalVertexDistance;

#ifdef PER_FACE_LIGHTING
in vec4 vertexPerFaceColorBack;
in vec4 vertexPerFaceColorFront;
#else
in vec4 vertexColor;
#endif

#ifndef NO_OVERLAY
in vec4 overlayColor;
#endif

in vec2 texCoord0;

out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0);

    #ifdef ALPHA_CUTOUT
    if (color.a < ALPHA_CUTOUT) {
        discard;
    }
    #endif

    #ifdef PER_FACE_LIGHTING
    vec4 faceVertexColor = gl_FrontFacing ? vertexPerFaceColorFront : vertexPerFaceColorBack;
    #else
    vec4 faceVertexColor = vertexColor;
    #endif

    color *= faceVertexColor * ColorModulator;

    #ifndef NO_OVERLAY
    color.rgb = mix(overlayColor.rgb, color.rgb, overlayColor.a);
    #endif

    float brightness = 1.0 - dot(color.rgb, vec3(0.2126, 0.7152, 0.0722));

    vec3 darkCyan = vec3(0.0, 0.20, 0.24);
    vec3 cyan = vec3(0.0, 0.85, 0.95);
    vec3 brightCyan = vec3(0.75, 1.0, 1.0);

    vec3 possessedColor = mix(darkCyan, cyan, brightness);
    possessedColor = mix(possessedColor, brightCyan, max(brightness - 0.65, 0.0) / 0.35);

    color.rgb = possessedColor;

    fragColor = apply_fog(
            color,
            sphericalVertexDistance,
            cylindricalVertexDistance,
            FogEnvironmentalStart,
            FogEnvironmentalEnd,
            FogRenderDistanceStart,
            FogRenderDistanceEnd,
            FogColor
    );
}