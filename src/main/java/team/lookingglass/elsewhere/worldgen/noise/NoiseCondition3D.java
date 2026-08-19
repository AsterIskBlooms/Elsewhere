package team.lookingglass.elsewhere.worldgen.noise;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public record NoiseCondition3D(
        ResourceKey<NormalNoise.NoiseParameters> noise,
        double minThreshold,
        double maxThreshold
) implements SurfaceRules.ConditionSource {

    public static NoiseCondition3D of(ResourceKey<NormalNoise.NoiseParameters> noise, double minRange) {
        return new NoiseCondition3D(noise, minRange, Double.MAX_VALUE);
    }

    public static NoiseCondition3D of(ResourceKey<NormalNoise.NoiseParameters> noise, double minRange, double maxRange) {
        return new NoiseCondition3D(noise, minRange, maxRange);
    }

    public static final KeyDispatchDataCodec<NoiseCondition3D> CODEC =
            KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceKey.codec(Registries.NOISE).fieldOf("noise").forGetter(NoiseCondition3D::noise),
                    Codec.DOUBLE.fieldOf("min_threshold").forGetter(NoiseCondition3D::minThreshold),
                    Codec.DOUBLE.fieldOf("max_threshold").forGetter(NoiseCondition3D::maxThreshold)
            ).apply(instance, NoiseCondition3D::new)));

    @Override
    public KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.Condition apply(SurfaceRules.Context context) {
        NormalNoise normalNoise = context.randomState.getOrCreateNoise(this.noise);
        return () -> {
            double value = normalNoise.getValue(
                    context.blockX,
                    context.blockY,
                    context.blockZ
            );
            return value >= minThreshold && value < maxThreshold;
        };
    }
}