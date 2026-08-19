package team.lookingglass.elsewhere.dimension.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.EBiomes;
import team.lookingglass.elsewhere.worldgen.noise.ENoise;
import team.lookingglass.elsewhere.worldgen.noise.NoiseCondition3D;

import java.util.List;

public class VeilrootWorldgen {
    public static final ResourceKey<NoiseGeneratorSettings> VEILROOT_NOISE_SETTINGS = ResourceKey.create(
            Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> ctx) {
        HolderGetter<DensityFunction> functions = ctx.lookup(Registries.DENSITY_FUNCTION);

        ctx.register(VEILROOT_NOISE_SETTINGS, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 96, 1, 1),
                EBlocks.SMOOTH_SOUL_SANDSTONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                buildRouter(functions),
                surfaceRule(),
                List.of(),
                -1,
                true,
                true,
                false,
                true
        ));
    }

    private static SurfaceRules.RuleSource surfaceRule() {
        SurfaceRules.RuleSource rottenGrove = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.ROTTEN_GROVE),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.25, 0.25),
                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))
                )
        );

        SurfaceRules.RuleSource sweepingSands = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.SWEEPING_SANDS),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                SurfaceRules.state(EBlocks.SOUL_SANDSTONE.defaultBlockState()))
                )
        );

        SurfaceRules.RuleSource frostedCrag = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.FROSTED_CRAG),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -0.5, 0.0),
                                        SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))),

                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.state(Blocks.ICE.defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState()))
                )
        );

        SurfaceRules.RuleSource broushForest = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.BROUSH_FOREST),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                SurfaceRules.state(Blocks.DIRT.defaultBlockState()))
                )
        );

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("veilroot_bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("veilroot_bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),

                rottenGrove, sweepingSands, frostedCrag, broushForest
        );

    }

    private static NoiseRouter buildRouter(HolderGetter<DensityFunction> functions) {
        DensityFunction continentalness = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.CONTINENTALNESS);
        DensityFunction erosion = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.EROSION);
        DensityFunction temperature = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.TEMPERATURE);
        DensityFunction humidity = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.HUMIDITY);
        DensityFunction depth = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.DEPTH);
        DensityFunction baseTerrain = NoiseRouterData.getFunction(functions, VeilrootDensityFunctions.BASE_TERRAIN);

        DensityFunction slide = NoiseRouterData.slide(baseTerrain, 0, 96, 32, 16, 0.9375, 10, 26, 2.5);
        DensityFunction fullNoise = NoiseRouterData.postProcess(slide);

        return new NoiseRouter(
                DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
                temperature, humidity, continentalness, erosion,
                depth, DensityFunctions.zero(), DensityFunctions.zero(),
                fullNoise,
                DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
    }
}