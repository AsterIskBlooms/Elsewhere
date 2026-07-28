package team.lookingglass.elsewhere.worldgen.features;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.BlockColumnClusterConfiguration;

public class BlockColumnClusterFeature extends Feature<BlockColumnClusterConfiguration> {
    public BlockColumnClusterFeature(final Codec<BlockColumnClusterConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(final FeaturePlaceContext<BlockColumnClusterConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockColumnClusterConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        int size = config.size().sample(random);
        int peakX = size % 2 == 1 ? size / 2 : random.nextInt(2) * (size - 1);
        int peakZ = size % 2 == 1 ? size / 2 : random.nextInt(2) * (size - 1);

        int layerCount = config.layers().size();
        int[] baseLayerHeights = new int[layerCount];
        int baseTotalHeight = 0;

        for (int i = 0; i < layerCount; i++) {
            baseLayerHeights[i] = config.layers().get(i).height().sample(random);
            baseTotalHeight += baseLayerHeights[i];
        }

        if (baseTotalHeight == 0) {
            return false;
        }

        int falloffPerStep = config.falloffPerStep().sample(random);
        int sunkenDepth = config.sunkenDepth().sample(random);
        BlockColumnConfiguration.Layer baseLayer = config.layers().get(0);
        boolean placedAny = false;

        for (int x = 0; x < size; x++) {
            for (int z = 0; z < size; z++) {
                int distance = Math.max(Math.abs(x - peakX), Math.abs(z - peakZ));
                int jitter = config.jitter().sample(random);
                int targetHeight = Math.min(baseTotalHeight, Math.max(0, baseTotalHeight - distance * falloffPerStep + jitter));

                if (targetHeight == 0) {
                    continue;
                }

                int[] layerHeights = baseLayerHeights.clone();
                truncate(layerHeights, baseTotalHeight, targetHeight, config.prioritizeTip());

                BlockPos.MutableBlockPos sunkenPos = origin.offset(x, 0, z).mutable().move(config.direction().getOpposite(), sunkenDepth);

                for (int y = 0; y < sunkenDepth; y++) {
                    level.setBlock(sunkenPos, baseLayer.state().getState(level, random, sunkenPos), 2);
                    sunkenPos.move(config.direction());
                    placedAny = true;
                }

                BlockPos.MutableBlockPos placePos = origin.offset(x, 0, z).mutable();
                BlockPos.MutableBlockPos nextPos = placePos.mutable().move(config.direction());
                int columnTotal = 0;

                for (int height : layerHeights) {
                    columnTotal += height;
                }

                for (int y = 0; y < columnTotal; y++) {
                    if (!config.allowedPlacement().test(level, nextPos)) {
                        truncate(layerHeights, columnTotal, y, config.prioritizeTip());
                        break;
                    }

                    nextPos.move(config.direction());
                }

                for (int i = 0; i < layerCount; i++) {
                    int count = layerHeights[i];

                    if (count != 0) {
                        BlockColumnConfiguration.Layer layer = config.layers().get(i);

                        for (int y = 0; y < count; y++) {
                            level.setBlock(placePos, layer.state().getState(level, random, placePos), 2);
                            placePos.move(config.direction());
                        }

                        placedAny = true;
                    }
                }
            }
        }

        return placedAny;
    }

    private static void truncate(final int[] layerHeights, final int totalHeight, final int newHeight, final boolean prioritizeTip) {
        int amountToRemove = totalHeight - newHeight;
        int direction = prioritizeTip ? 1 : -1;
        int start = prioritizeTip ? 0 : layerHeights.length - 1;
        int end = prioritizeTip ? layerHeights.length : -1;

        for (int i = start; i != end && amountToRemove > 0; i += direction) {
            int thisLayer = layerHeights[i];
            int toRemoveFromLayer = Math.min(thisLayer, amountToRemove);
            amountToRemove -= toRemoveFromLayer;
            layerHeights[i] -= toRemoveFromLayer;
        }
    }
}