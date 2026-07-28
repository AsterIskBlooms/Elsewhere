package team.lookingglass.elsewhere.worldgen.features.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class SeaLevelFilter extends PlacementFilter {
    public static final MapCodec<SeaLevelFilter> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(Codec.INT.fieldOf("min_offset").forGetter(SeaLevelFilter::minOffset), Codec.INT.fieldOf("max_offset").forGetter(SeaLevelFilter::maxOffset)).apply(i, SeaLevelFilter::new));

    private final int minOffset;
    private final int maxOffset;

    public SeaLevelFilter(final int minOffset, final int maxOffset) {
        this.minOffset = minOffset;
        this.maxOffset = maxOffset;
    }

    public int minOffset() {
        return this.minOffset;
    }

    public int maxOffset() {
        return this.maxOffset;
    }

    public static SeaLevelFilter of(final int minOffset, final int maxOffset) {
        return new SeaLevelFilter(minOffset, maxOffset);
    }

    @Override
    protected boolean shouldPlace(final PlacementContext context, final RandomSource random, final BlockPos pos) {
        int relative = pos.getY() - context.getLevel().getSeaLevel();
        return relative >= this.minOffset && relative <= this.maxOffset;
    }

    @Override
    public PlacementModifierType<?> type() {
        return EPlacementModifiers.SEA_LEVEL_FILTER;
    }
}