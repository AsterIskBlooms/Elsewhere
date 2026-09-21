package team.lookingglass.elsewhere.entity.renderer;

import com.mojang.blaze3d.pipeline.DepthStencilState;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.shaders.UniformType;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;

public class PossessionRenderTypes {
    private static final RenderPipeline possessedEntityPipeline = RenderPipelines.register(
            RenderPipeline.builder(
                            RenderPipeline.builder()
                                    .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
                                    .withUniform("Projection", UniformType.UNIFORM_BUFFER)
                                    .withUniform("Fog", UniformType.UNIFORM_BUFFER)
                                    .withUniform("Lighting", UniformType.UNIFORM_BUFFER)
                                    .buildSnippet()
                    )
                    .withLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "pipeline/possessed_entity"))
                    .withVertexShader(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "core/possessed_entity"))
                    .withFragmentShader(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "core/possessed_entity"))
                    .withSampler("Sampler0")
                    .withSampler("Sampler1")
                    .withShaderDefine("PER_FACE_LIGHTING")
                    .withShaderDefine("EMISSIVE")
                    .withShaderDefine("ALPHA_CUTOUT", 0.1F)
                    .withVertexFormat(DefaultVertexFormat.ENTITY, VertexFormat.Mode.QUADS)
                    .withCull(false)
                    .withDepthStencilState(DepthStencilState.DEFAULT)
                    .build()
    );

    public static RenderType possessedEntity(Identifier texture) {
        RenderSetup setup = RenderSetup.builder(possessedEntityPipeline)
                .withTexture("Sampler0", texture)
                .useOverlay()
                .affectsCrumbling()
                .createRenderSetup();

        return RenderType.create("possessed_entity", setup);
    }
}