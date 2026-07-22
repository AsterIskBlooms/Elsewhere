package team.lookingglass.elsewhere.registry.blocktypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.Nullable;
import team.lookingglass.elsewhere.registry.render.EParticles;
import team.lookingglass.elsewhere.registry.ESounds;
import team.lookingglass.elsewhere.registry.render.particles.GeyserParticleOptions;
import team.lookingglass.elsewhere.registry.properties.blockstates.PotentSulfurState;

import java.util.*;
import java.util.function.Predicate;

import static team.lookingglass.elsewhere.registry.blocktypes.PotentSulfurBlock.ALLOWED_WATER_BLOCKS_ABOVE;

public class PotentSulfurBlockEntity extends BlockEntity {
    private static final int EFFECT_APPLICATION_FREQUENCY_TICKS = 10;
    private static final float EFFECT_DURATION_IN_SECONDS = 4.0F;
    private static final int EFFECT_DURATION_IN_TICKS = 80;
    public static final float EFFECT_RANGE = 3.0F;
    private static final Predicate<Entity> EFFECT_PREDICATE = EntitySelector.NO_SPECTATORS.and(EntitySelector.ENTITY_STILL_ALIVE);
    public static final int PARTICLE_FREQUENCY_TICKS = 20;
    private static final float GEYSER_BASE_LAUNCH_SPEED = 0.3F;
    private static final float GEYSER_LAUNCH_FORCE = 0.2F;
    public int waitingCountdown = -1;
    public int geyserEruptionTime = -1;
    public int dormantGeyserTime = -1;
    public long eruptionTick = -1L;
    public static BlockEntityTicker<PotentSulfurBlockEntity> SERVER_NAUSEA_EFFECT_TICKER = (level, pos, state, potentSulfur) -> {
        if (level.getGameTime() % 10L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(level, pos);
            if (sourceBlock != null) {
                for (LivingEntity entity : getNearbyLivingEntities(level, pos)) {
                    if (entity instanceof Player) continue; // players handled by EServerEvents
                    if (canBeReachedByNoxiousGas(level, sourceBlock, entity.getEyePosition())) {
                        applyNauseaEffect(entity);
                    }
                }
            }
        }
    };

    public static BlockEntityTicker<PotentSulfurBlockEntity> CLIENT_NOXIOUS_GAS_TICKER = (level, pos, state, entity) -> {
        if (level.getGameTime() % 20L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(level, pos);
            if (sourceBlock != null) {
                spawnNoxiousGasCloudParticle(level, Vec3.atCenterOf(sourceBlock));
            }
        }
    };
    public static BlockEntityTicker<PotentSulfurBlockEntity> CLIENT_GEYSER_PLUME_TICKER = (level, pos, state, entity) -> {
        BlockPos sourceBlock = findNoxiousGasSourceBlock(level, pos);
        if (sourceBlock != null) {
            if ((level.getGameTime() - entity.eruptionTick) % 20L == 0L) {
                spawnGeyserParticle(level, pos, sourceBlock);
            }
        }
    };
    public static BlockEntityTicker<PotentSulfurBlockEntity> SERVER_WAITING_COUNTDOWN_TICKER = (level, pos, state, entity) -> {
        if (level.getGameTime() % 20L == 0L) {
            BlockPos sourceBlock = findNoxiousGasSourceBlock(level, pos);
            if (sourceBlock != null) {
                if (entity.waitingCountdown <= 0) {
                    int waterBlocks = sourceBlock.getY() - pos.getY() - 1;
                    if (state.getValue(PotentSulfurBlock.STATE) == PotentSulfurState.DORMANT) {
                        entity.waitingCountdown = 10 * (waterBlocks - 1) + entity.dormantGeyserTime;
                    } else {
                        entity.waitingCountdown = waterBlocks - 1 + entity.geyserEruptionTime;
                    }
                }

                if (entity.waitingCountdown > 0) {
                    entity.waitingCountdown--;
                }

                if (entity.waitingCountdown == 0) {
                    boolean lavaBelow = level.getFluidState(pos.below()).isSourceOfType(Fluids.LAVA);
                    PotentSulfurState stateToSet = (lavaBelow || state.getValue(PotentSulfurBlock.STATE) == PotentSulfurState.DORMANT)
                            ? PotentSulfurState.ERUPTING
                            : PotentSulfurState.DORMANT;
                    level.setBlock(pos, state.setValue(PotentSulfurBlock.STATE, stateToSet), 3);
                    if (stateToSet == PotentSulfurState.DORMANT) {
                        level.gameEvent(GameEvent.BLOCK_DEACTIVATE, pos, GameEvent.Context.of(state));
                    }
                }
            }
        }
    };
    public static BlockEntityTicker<PotentSulfurBlockEntity> SERVER_LAUNCH_ENTITY_TICKER = (level, pos, state, entity) -> {
        BlockPos sourceBlock = findNoxiousGasSourceBlock(level, pos);
        if (sourceBlock != null) {
            int waterBlocks = sourceBlock.getY() - pos.getY() - 1;
            int geyserForceHeight = waterBlocks * 6;
            AABB aabb = new AABB(pos.above()).expandTowards(0.0, geyserForceHeight - 1, 0.0);

            for (Entity entityToBeLaunched : level.getEntitiesOfClass(Entity.class, aabb, EFFECT_PREDICATE)) {
                Vec3 entityVelocity = entityToBeLaunched.getDeltaMovement();
                if (!(entityToBeLaunched instanceof Player player && player.getAbilities().flying)
                        && entityVelocity.y < 0.3F + waterBlocks * 0.1
                        && haveLineOfSight(level, Vec3.atCenterOf(sourceBlock.below()), entityToBeLaunched.getEyePosition())) {
                    entityToBeLaunched.addDeltaMovement(new Vec3(0.0, 0.2F, 0.0));
                    entityToBeLaunched.hurtMarked = true;
                    entityToBeLaunched.needsSync = true;
                }
            }

            if (level.getGameTime() % 20L == 0L) {
                level.playSound(null, pos, ESounds.GEYSER_ERUPTION_ACTIVE, SoundSource.BLOCKS, 1.0F * waterBlocks, 1.0F);
            }
        }
    };

    public PotentSulfurBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(EBlockEntityTypes.POTENT_SULFUR, worldPosition, blockState);
    }

    @Override
    protected void saveAdditional(final ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("dormant_time", this.dormantGeyserTime);
        output.putInt("eruption_time", this.geyserEruptionTime);
        output.putInt("countdown", this.waitingCountdown);
    }

    @Override
    protected void loadAdditional(final ValueInput input) {
        super.loadAdditional(input);
        input.getInt("dormant_time").ifPresent(value -> this.dormantGeyserTime = value);
        input.getInt("eruption_time").ifPresent(value -> this.geyserEruptionTime = value);
        input.getInt("countdown").ifPresent(value -> this.waitingCountdown = value);
    }

    @Override
    public void setLevel(final Level level) {
        super.setLevel(level);
        if (this.geyserEruptionTime == -1) {
            this.geyserEruptionTime = level.getRandom().nextIntBetweenInclusive(3, 6);
        }

        if (this.dormantGeyserTime == -1) {
            this.dormantGeyserTime = level.getRandom().nextIntBetweenInclusive(15, 30);
        }

        if (this.eruptionTick == -1L) {
            this.eruptionTick = level.getGameTime();
        }
    }

    private static void applyNauseaEffect(final LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 80, 0, true, true));
    }

    public void resetCountdown() {
        this.waitingCountdown = -1;
    }

    private static List<LivingEntity> getNearbyLivingEntities(final Level level, final BlockPos pos) {
        AABB aabb = new AABB(pos).inflate(2.5, ALLOWED_WATER_BLOCKS_ABOVE + 1, 2.5);
        return level.getEntitiesOfClass(LivingEntity.class, aabb, EFFECT_PREDICATE);
    }

    private static void spawnGeyserParticle(final Level level, final BlockPos sulfurPos, final BlockPos sourcePos) {
        int waterBlocks = sourcePos.getY() - sulfurPos.getY() - 1;
        level.addParticle(
                new GeyserParticleOptions(EParticles.GEYSER, waterBlocks), sourcePos.getX() + 0.5, sourcePos.getY(), sourcePos.getZ() + 0.5, 0.0, 0.0, 0.0
        );
    }

    private static void spawnNoxiousGasCloudParticle(final Level level, final Vec3 pos) {
        level.addParticle(EParticles.NOXIOUS_GAS_CLOUD, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
    }

    private static @Nullable BlockPos findNoxiousGasSourceBlock(final Level level, final BlockPos origin) {
        int maxY = origin.getY() + 4 + 1;
        BlockPos.MutableBlockPos pos = origin.above(2).mutable();

        while (pos.getY() <= maxY) {
            if (!level.getFluidState(pos).isSourceOfType(Fluids.WATER)) {
                if (level.getBlockState(pos).isAir()) {
                    return pos.immutable();
                }
                break;
            }

            pos.move(Direction.UP);
        }

        return null;
    }

    public static boolean canBeReachedByNoxiousGas(final Level level, final BlockPos sourceBlock, final Vec3 pos) {
        if (pos.distanceToSqr(Vec3.atCenterOf(sourceBlock)) > 9.0) {
            return false;
        }
        BlockState eyeState = level.getBlockState(BlockPos.containing(pos));
        if (!eyeState.isAir() && !eyeState.getFluidState().isSourceOfType(Fluids.WATER)) {
            return false;
        }
        Vec3 belowSource = Vec3.atCenterOf(sourceBlock.below());
        Vec3 belowPos = pos.with(Direction.Axis.Y, pos.y - 1.0);
        return isWater(level, belowPos) && haveLineOfSight(level, belowSource, belowPos);
    }

    public static boolean haveLineOfSight(final Level level, final Vec3 a, final Vec3 b) {
        HitResult hitResult = level.clip(new ClipContext(a, b, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, CollisionContext.empty()));
        return hitResult.getType() != HitResult.Type.BLOCK;
    }

    private static boolean isUnderwater(final Level level, final BlockPos pos) {
        return level.getFluidState(pos.above()).isSourceOfType(Fluids.WATER);
    }

    private static boolean isWater(final Level level, final Vec3 pos) {
        return level.getFluidState(BlockPos.containing(pos)).isSourceOfType(Fluids.WATER);
    }

    private static boolean isAir(final Level level, final Vec3 pos) {
        return level.getBlockState(BlockPos.containing(pos)).isAir();
    }
}
