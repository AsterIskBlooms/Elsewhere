package team.lookingglass.elsewhere.worldgen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record BlockColumnClusterConfiguration(List<BlockColumnConfiguration.Layer> layers, Direction direction, BlockPredicate allowedPlacement, boolean prioritizeTip, IntProvider size, IntProvider falloffPerStep, IntProvider jitter, IntProvider sunkenDepth) implements FeatureConfiguration {
    public static final Codec<BlockColumnClusterConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(BlockColumnConfiguration.Layer.CODEC.listOf().fieldOf("layers").forGetter(BlockColumnClusterConfiguration::layers), Direction.CODEC.fieldOf("direction").forGetter(BlockColumnClusterConfiguration::direction), BlockPredicate.CODEC.fieldOf("allowed_placement").forGetter(BlockColumnClusterConfiguration::allowedPlacement), Codec.BOOL.fieldOf("prioritize_tip").forGetter(BlockColumnClusterConfiguration::prioritizeTip), IntProviders.CODEC.fieldOf("size").forGetter(BlockColumnClusterConfiguration::size), IntProviders.CODEC.fieldOf("falloff_per_step").forGetter(BlockColumnClusterConfiguration::falloffPerStep), IntProviders.CODEC.fieldOf("jitter").forGetter(BlockColumnClusterConfiguration::jitter), IntProviders.CODEC.fieldOf("sunken_depth").forGetter(BlockColumnClusterConfiguration::sunkenDepth)).apply(i, BlockColumnClusterConfiguration::new));
}
