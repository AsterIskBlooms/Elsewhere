package team.lookingglass.elsewhere.worldgen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record BlockPatchConfiguration(
        BlockStateProvider toPlace,
        BlockPredicate validGround,
        BlockPredicate replaceable,
        int baseRadius,
        int radiusVariance,
        int baseCount,
        int countVariance,
        Direction scanDirection,
        int maxScanDistance
) implements FeatureConfiguration {

    private static final Codec<Direction> VERTICAL_DIRECTION_CODEC = Direction.CODEC.validate(direction ->
            direction.getAxis() == Direction.Axis.Y
                    ? com.mojang.serialization.DataResult.success(direction)
                    : com.mojang.serialization.DataResult.error(() -> "Expected UP or DOWN, got " + direction));

    public static final Codec<BlockPatchConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(BlockPatchConfiguration::toPlace),
            BlockPredicate.CODEC.fieldOf("valid_ground").forGetter(BlockPatchConfiguration::validGround),
            BlockPredicate.CODEC.optionalFieldOf("replaceable", BlockPredicate.replaceable()).forGetter(BlockPatchConfiguration::replaceable),
            Codec.INT.fieldOf("base_radius").forGetter(BlockPatchConfiguration::baseRadius),
            Codec.INT.fieldOf("radius_variance").forGetter(BlockPatchConfiguration::radiusVariance),
            Codec.INT.fieldOf("base_count").forGetter(BlockPatchConfiguration::baseCount),
            Codec.INT.fieldOf("count_variance").forGetter(BlockPatchConfiguration::countVariance),
            VERTICAL_DIRECTION_CODEC.optionalFieldOf("scan_direction", Direction.DOWN).forGetter(BlockPatchConfiguration::scanDirection),
            Codec.INT.optionalFieldOf("max_scan_distance", 8).forGetter(BlockPatchConfiguration::maxScanDistance)
    ).apply(instance, BlockPatchConfiguration::new));
}