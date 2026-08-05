package team.lookingglass.elsewhere.worldgen.features.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import team.lookingglass.elsewhere.worldgen.EFeatures;

public class PoplarFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(i -> foliagePlacerParts(i).and(i.group(
            IntProviders.codec(0, 20).fieldOf("top_extension").forGetter(p -> p.topExtension),
            IntProviders.codec(0, 20).fieldOf("bottom_extension").forGetter(p -> p.bottomExtension),
            Codec.intRange(0, 4).fieldOf("max_radius").forGetter(p -> p.maxRadius),
            Codec.floatRange(0.5F, 6.0F).fieldOf("taper_exponent").forGetter(p -> p.taperExponent)
    )).apply(i, PoplarFoliagePlacer::new));

    private final IntProvider topExtension;
    private final IntProvider bottomExtension;
    private final int maxRadius;
    private final float taperExponent;

    public PoplarFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider topExtension, IntProvider bottomExtension, int maxRadius, float taperExponent) {
        super(radius, offset);
        this.topExtension = topExtension;
        this.bottomExtension = bottomExtension;
        this.maxRadius = maxRadius;
        this.taperExponent = taperExponent;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EFeatures.POPLAR_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliageAttachment attachment, int foliageHeight, int leafRadius, int offset) {
        int above = this.topExtension.sample(random);
        int below = Math.clamp(treeHeight - 1, 0, this.bottomExtension.sample(random));
        BlockPos startPos = attachment.pos().above(offset + above);
        int lobeHeight = above + below;

        for (int i = 0; i < lobeHeight; ++i) {
            double t = (i + 0.5) / lobeHeight;
            double profile = Math.pow(Math.sin(Math.PI * t), this.taperExponent);
            int currentRadius = (int) Math.round(this.maxRadius * profile);
            this.placeLeavesRow(level, foliageSetter, random, config, startPos, currentRadius, -i, attachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int treeHeight, TreeConfiguration config) {
        return this.topExtension.maxInclusive() + this.bottomExtension.maxInclusive();
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        return dx == currentRadius && dz == currentRadius && (random.nextInt(2) == 0 || y == 0);
    }
}