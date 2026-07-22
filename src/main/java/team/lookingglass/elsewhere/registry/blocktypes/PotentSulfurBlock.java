package team.lookingglass.elsewhere.registry.blocktypes;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.material.Fluids;
import org.jspecify.annotations.Nullable;
import team.lookingglass.elsewhere.registry.properties.EBlockStateProperties;
import team.lookingglass.elsewhere.registry.render.EParticles;
import team.lookingglass.elsewhere.registry.ESounds;
import team.lookingglass.elsewhere.registry.properties.blockstates.PotentSulfurState;
import static team.lookingglass.elsewhere.registry.util.BlockEntityTickers.andThen;

public class PotentSulfurBlock extends BaseEntityBlock {
    public static final int ALLOWED_WATER_BLOCKS_ABOVE = 4;
    public static final MapCodec<PotentSulfurBlock> CODEC = simpleCodec(PotentSulfurBlock::new);
    public static final EnumProperty<PotentSulfurState> STATE = EBlockStateProperties.POTENT_SULFUR_STATE;

    @Override
    public MapCodec<PotentSulfurBlock> codec() {
        return CODEC;
    }

    public PotentSulfurBlock(final Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(STATE, PotentSulfurState.DRY));
    }

    @Override
    protected void createBlockStateDefinition(final Builder<Block, BlockState> builder) {
        builder.add(STATE);
    }

    public @Nullable BlockEntity newBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        return new PotentSulfurBlockEntity(worldPosition, blockState);
    }

    @Override
    protected BlockState updateShape(
            final BlockState state,
            final LevelReader level,
            final ScheduledTickAccess ticks,
            final BlockPos pos,
            final Direction directionToNeighbour,
            final BlockPos neighbourPos,
            final BlockState neighbourState,
            final RandomSource random
    ) {
        return validBlockState(state, level, pos);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(final BlockPlaceContext context) {
        return validBlockState(this.defaultBlockState(), context.getLevel(), context.getClickedPos());
    }

    private static BlockState validBlockState(final BlockState state, final LevelReader level, final BlockPos pos) {
        if (!level.getFluidState(pos.above()).isSourceOfType(Fluids.WATER)) {
            return state.setValue(STATE, PotentSulfurState.DRY);
        }

        BlockState belowState = level.getBlockState(pos.below());
        boolean hasMagma = belowState.is(Blocks.MAGMA_BLOCK);
        boolean hasLava = level.getFluidState(pos.below()).isSourceOfType(Fluids.LAVA);

        if (!hasMagma && !hasLava) {
            return state.setValue(STATE, PotentSulfurState.WET);
        }

        boolean isGeyser = state.getValue(STATE) == PotentSulfurState.ERUPTING
                || state.getValue(STATE) == PotentSulfurState.DORMANT;

        if (!isGeyser && level.getBlockEntity(pos) instanceof PotentSulfurBlockEntity potentSulfurEntity) {
            potentSulfurEntity.resetCountdown();
        }

        if (hasLava) {
            return state.setValue(STATE, PotentSulfurState.ERUPTING);
        }

        return state.getValue(STATE) == PotentSulfurState.ERUPTING
                ? state
                : state.setValue(STATE, PotentSulfurState.DORMANT);
    }

    @Override
    protected void onPlace(final BlockState state, final Level level, final BlockPos pos, final BlockState oldState, final boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if (state.getValue(STATE) == PotentSulfurState.ERUPTING) {
            level.blockEvent(pos, this, 0, 0);
            level.playSound(null, pos, ESounds.GEYSER_ERUPTION_START, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(GameEvent.BLOCK_ACTIVATE, pos, Context.of(state));
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState newState = validBlockState(state, level, pos);
        if (newState != state) {
            level.setBlock(pos, newState, 3);
        }
    }

    @Override
    public void animateTick(final BlockState state, final Level level, final BlockPos pos, final RandomSource random) {
        if (state.getValue(STATE) != PotentSulfurState.DRY) {
            if (level.getFluidState(pos.above()).isSourceOfType(Fluids.WATER)) {
                spawnBubbleParticlesAt(level, random, pos.getX(), pos.getY() + 1, pos.getZ());
                spawnBubbleParticlesAt(level, random, pos.getX(), pos.getY() + 1, pos.getZ());
                if (random.nextInt(10) == 0) {
                    level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), ESounds.NOXIOUS_GAS, SoundSource.AMBIENT, 1.0F, 1.0F, false);
                }
            }
        }
    }

    private static void spawnBubbleParticlesAt(final Level level, final RandomSource random, final double x, final double y, final double z) {
        level.addAlwaysVisibleParticle(EParticles.SULFUR_BUBBLES, x + random.nextFloat(), y + random.nextFloat(), z + random.nextFloat(), 0.0, 0.0, 0.0);
    }

    @Override
    protected boolean triggerEvent(final BlockState state, final Level level, final BlockPos pos, final int b0, final int b1) {
        if (level.getBlockEntity(pos) instanceof PotentSulfurBlockEntity entity) {
            entity.eruptionTick = level.getGameTime();
        }

        return true;
    }

    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(final Level level, final BlockState blockState, final BlockEntityType<T> type) {
        boolean client = level.isClientSide();

        return createTickerHelper(
                type,
                EBlockEntityTypes.POTENT_SULFUR,
                switch ((PotentSulfurState)blockState.getValue(STATE)) {
                    case DRY -> null;
                    case WET -> client ? PotentSulfurBlockEntity.CLIENT_NOXIOUS_GAS_TICKER : PotentSulfurBlockEntity.SERVER_NAUSEA_EFFECT_TICKER;
                    case DORMANT -> client
                            ? PotentSulfurBlockEntity.CLIENT_NOXIOUS_GAS_TICKER
                            : andThen(
                            PotentSulfurBlockEntity.SERVER_WAITING_COUNTDOWN_TICKER,
                            PotentSulfurBlockEntity.SERVER_NAUSEA_EFFECT_TICKER);
                    case ERUPTING -> client
                            ? PotentSulfurBlockEntity.CLIENT_GEYSER_PLUME_TICKER
                            : andThen(
                            PotentSulfurBlockEntity.SERVER_LAUNCH_ENTITY_TICKER,
                            PotentSulfurBlockEntity.SERVER_WAITING_COUNTDOWN_TICKER);
                }
        );
    }
}

