package team.lookingglass.elsewhere.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import team.lookingglass.elsewhere.worldgen.features.config.TidePoolConfiguration;

public class TidePoolFeature extends Feature<TidePoolConfiguration> {
    private static final int NONE = 0;
    private static final int RIM = 1;
    private static final int BASIN = 2;

    public TidePoolFeature(final Codec<TidePoolConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(final FeaturePlaceContext<TidePoolConfiguration> context) {
        WorldGenLevel level = context.level();
        TidePoolConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        int lobeCount = Math.max(1, config.lobeCount().sample(random));
        int[] lobeDx = new int[lobeCount];
        int[] lobeDz = new int[lobeCount];
        int[] lobeRadius = new int[lobeCount];
        int maxReach = 0;
        int primaryLobe = 0;

        for (int i = 0; i < lobeCount; i++) {
            int offset = config.lobeOffset().sample(random);
            lobeDx[i] = random.nextBoolean() ? offset : -offset;
            lobeDz[i] = random.nextBoolean() ? offset : -offset;
            lobeRadius[i] = config.lobeRadius().sample(random);
            maxReach = Math.max(maxReach, Math.abs(lobeDx[i]) + lobeRadius[i]);
            maxReach = Math.max(maxReach, Math.abs(lobeDz[i]) + lobeRadius[i]);

            if (lobeRadius[i] > lobeRadius[primaryLobe]) {
                primaryLobe = i;
            }
        }

        int bounds = maxReach + 2;
        int width = bounds * 2 + 1;
        int[][] classification = new int[width][width];

        for (int xi = 0; xi < width; xi++) {
            for (int zi = 0; zi < width; zi++) {
                int x = xi - bounds;
                int z = zi - bounds;
                double edgeDistance = Double.POSITIVE_INFINITY;

                for (int i = 0; i < lobeCount; i++) {
                    double dx = x - lobeDx[i];
                    double dz = z - lobeDz[i];
                    double distance = Math.sqrt(dx * dx + dz * dz) - lobeRadius[i];
                    edgeDistance = Math.min(edgeDistance, distance);
                }

                if (edgeDistance <= 0.0) {
                    classification[xi][zi] = BASIN;
                } else if (edgeDistance <= 1.0) {
                    classification[xi][zi] = RIM;
                }
            }
        }

        for (int xi = 0; xi < width; xi++) {
            for (int zi = 0; zi < width; zi++) {
                if (classification[xi][zi] == BASIN) {
                    patchGap(classification, xi - 1, zi, width);
                    patchGap(classification, xi + 1, zi, width);
                    patchGap(classification, xi, zi - 1, width);
                    patchGap(classification, xi, zi + 1, width);
                }
            }
        }

        int depth = Math.max(2, config.depth().sample(random));
        int deepSpotRadius = config.deepSpotRadius().sample(random);
        int deepSpotBonus = config.deepSpotBonus().sample(random);
        int deepCenterX = lobeDx[primaryLobe];
        int deepCenterZ = lobeDz[primaryLobe];
        boolean placedAny = false;

        for (int xi = 0; xi < width; xi++) {
            for (int zi = 0; zi < width; zi++) {
                int cls = classification[xi][zi];

                if (cls == NONE) {
                    continue;
                }

                int x = xi - bounds;
                int z = zi - bounds;
                BlockPos surfacePos = origin.offset(x, 0, z);

                if (cls == BASIN) {
                    int clearHeight = config.clearHeight().sample(random);
                    BlockPos.MutableBlockPos clearPos = surfacePos.mutable();

                    for (int y = 0; y < clearHeight; y++) {
                        clearPos.move(Direction.UP);
                        level.setBlock(clearPos, Blocks.AIR.defaultBlockState(), 2);
                    }

                    double deepDx = x - deepCenterX;
                    double deepDz = z - deepCenterZ;
                    boolean isDeepSpot = Math.sqrt(deepDx * deepDx + deepDz * deepDz) <= deepSpotRadius;
                    int cellDepth = isDeepSpot ? depth + deepSpotBonus : depth;

                    BlockPos.MutableBlockPos pos = surfacePos.mutable();

                    for (int y = 0; y < cellDepth; y++) {
                        if (y == cellDepth - 1) {
                            level.setBlock(pos, config.floor().getState(level, random, pos), 2);
                        } else if (y == cellDepth - 2) {
                            if (random.nextFloat() < config.coralProbability()) {
                                level.setBlock(pos, config.coral().getState(level, random, pos), 2);
                            } else if (random.nextFloat() < config.seagrassProbability()) {
                                if (cellDepth >= 3 && random.nextFloat() < config.tallSeagrassChance()) {
                                    level.setBlock(pos, Blocks.TALL_SEAGRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 2);
                                    level.setBlock(pos.above(), Blocks.TALL_SEAGRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
                                } else {
                                    level.setBlock(pos, Blocks.SEAGRASS.defaultBlockState(), 3);
                                }
                            } else {
                                level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
                            }
                        } else {
                            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
                        }

                        pos.move(Direction.DOWN);
                    }

                    int foundationDepth = config.foundationDepth().sample(random);

                    for (int y = 0; y < foundationDepth; y++) {
                        level.setBlock(pos, config.floor().getState(level, random, pos), 2);
                        pos.move(Direction.DOWN);
                    }

                    placedAny = true;
                } else {
                    boolean tall = random.nextFloat() < config.tallRimChance();
                    int extraHeight = tall ? config.rimHeight().sample(random) : 0;
                    BlockPos.MutableBlockPos pos = surfacePos.mutable();

                    for (int y = 0; y <= extraHeight; y++) {
                        level.setBlock(pos, config.rim().getState(level, random, pos), 2);
                        pos.move(Direction.UP);
                    }

                    int foundationDepth = config.foundationDepth().sample(random);
                    pos = surfacePos.mutable();

                    for (int y = 0; y < foundationDepth; y++) {
                        pos.move(Direction.DOWN);
                        level.setBlock(pos, config.rim().getState(level, random, pos), 2);
                    }

                    placedAny = true;
                }
            }
        }

        return placedAny;
    }

    private static void patchGap(final int[][] classification, final int xi, final int zi, final int width) {
        if (xi >= 0 && xi < width && zi >= 0 && zi < width && classification[xi][zi] == NONE) {
            classification[xi][zi] = RIM;
        }
    }
}