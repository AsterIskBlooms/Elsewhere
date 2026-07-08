package team.lookingglass.elsewhere.worldgen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record BlockPatchConfiguration(
        BlockStateProvider toPlace,
        TagKey<Block> validGround,
        int baseRadius,
        int radiusVariance,
        int baseCount,
        int countVariance
) implements FeatureConfiguration {

    public static final Codec<BlockPatchConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(BlockPatchConfiguration::toPlace),
            TagKey.hashedCodec(net.minecraft.core.registries.Registries.BLOCK).fieldOf("valid_ground").forGetter(BlockPatchConfiguration::validGround),
            Codec.INT.fieldOf("base_radius").forGetter(BlockPatchConfiguration::baseRadius),
            Codec.INT.fieldOf("radius_variance").forGetter(BlockPatchConfiguration::radiusVariance),
            Codec.INT.fieldOf("base_count").forGetter(BlockPatchConfiguration::baseCount),
            Codec.INT.fieldOf("count_variance").forGetter(BlockPatchConfiguration::countVariance)
    ).apply(instance, BlockPatchConfiguration::new));
}