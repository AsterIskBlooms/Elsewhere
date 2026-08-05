package team.lookingglass.elsewhere.worldgen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record TidePoolConfiguration(IntProvider lobeCount, IntProvider lobeRadius, IntProvider lobeOffset, IntProvider depth, IntProvider deepSpotRadius, IntProvider deepSpotBonus, IntProvider rimThickness, IntProvider rimHeight, float tallRimChance, IntProvider clearHeight, IntProvider foundationDepth, BlockStateProvider floor, BlockStateProvider rim, BlockStateProvider coral, float coralProbability, float seagrassProbability, float tallSeagrassChance) implements FeatureConfiguration {
    private record Shape(IntProvider lobeCount, IntProvider lobeRadius, IntProvider lobeOffset, IntProvider depth, IntProvider deepSpotRadius, IntProvider deepSpotBonus, IntProvider rimThickness, IntProvider rimHeight) {
        static final MapCodec<Shape> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(
                IntProviders.CODEC.fieldOf("lobe_count").forGetter(Shape::lobeCount),
                IntProviders.CODEC.fieldOf("lobe_radius").forGetter(Shape::lobeRadius),
                IntProviders.CODEC.fieldOf("lobe_offset").forGetter(Shape::lobeOffset),
                IntProviders.CODEC.fieldOf("depth").forGetter(Shape::depth),
                IntProviders.CODEC.fieldOf("deep_spot_radius").forGetter(Shape::deepSpotRadius),
                IntProviders.CODEC.fieldOf("deep_spot_bonus").forGetter(Shape::deepSpotBonus),
                IntProviders.CODEC.fieldOf("rim_thickness").forGetter(Shape::rimThickness),
                IntProviders.CODEC.fieldOf("rim_height").forGetter(Shape::rimHeight)
        ).apply(i, Shape::new));
    }
    private record Detail(float tallRimChance, IntProvider clearHeight, IntProvider foundationDepth, BlockStateProvider floor, BlockStateProvider rim, BlockStateProvider coral, float coralProbability, float seagrassProbability, float tallSeagrassChance) {
        static final MapCodec<Detail> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(
                Codec.floatRange(0.0F, 1.0F).fieldOf("tall_rim_chance").forGetter(Detail::tallRimChance),
                IntProviders.CODEC.fieldOf("clear_height").forGetter(Detail::clearHeight),
                IntProviders.CODEC.fieldOf("foundation_depth").forGetter(Detail::foundationDepth),
                BlockStateProvider.CODEC.fieldOf("floor").forGetter(Detail::floor),
                BlockStateProvider.CODEC.fieldOf("rim").forGetter(Detail::rim),
                BlockStateProvider.CODEC.fieldOf("coral").forGetter(Detail::coral),
                Codec.floatRange(0.0F, 1.0F).fieldOf("coral_probability").forGetter(Detail::coralProbability),
                Codec.floatRange(0.0F, 1.0F).fieldOf("seagrass_probability").forGetter(Detail::seagrassProbability),
                Codec.floatRange(0.0F, 1.0F).fieldOf("tall_seagrass_chance").forGetter(Detail::tallSeagrassChance)
        ).apply(i, Detail::new));
    }

    public static final Codec<TidePoolConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(
            Shape.CODEC.forGetter((c) -> new Shape(c.lobeCount(), c.lobeRadius(), c.lobeOffset(), c.depth(), c.deepSpotRadius(), c.deepSpotBonus(), c.rimThickness(), c.rimHeight())),
            Detail.CODEC.forGetter((c) -> new Detail(c.tallRimChance(), c.clearHeight(), c.foundationDepth(), c.floor(), c.rim(), c.coral(), c.coralProbability(), c.seagrassProbability(), c.tallSeagrassChance()))
    ).apply(i, (shape, detail) -> new TidePoolConfiguration(shape.lobeCount(), shape.lobeRadius(), shape.lobeOffset(), shape.depth(), shape.deepSpotRadius(), shape.deepSpotBonus(), shape.rimThickness(), shape.rimHeight(), detail.tallRimChance(), detail.clearHeight(), detail.foundationDepth(), detail.floor(), detail.rim(), detail.coral(), detail.coralProbability(), detail.seagrassProbability(), detail.tallSeagrassChance())));
}