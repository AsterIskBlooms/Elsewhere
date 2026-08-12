package team.lookingglass.elsewhere.registry.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.blocktypes.PotentSulfurBlockEntity;

import java.util.HashMap;
import java.util.Map;

public class NoxiousGasEvents {
    private static final Map<Integer, Integer> timeInPool = new HashMap<>();
    private static final int TICKS_BEFORE_POISON = 120;

    public static void onServerTick(MinecraftServer server) {
        if (server.getTickCount() % 10 != 0) return;

        for (ServerLevel level : server.getAllLevels()) {
            for (Player player : level.players()) {
                BlockPos playerPos = player.blockPosition();
                boolean inAnySulfurPool = false;

                for (BlockPos checkPos : BlockPos.betweenClosed(
                        playerPos.offset(-4, -1, -4),
                        playerPos.offset(4, 5, 4))) {
                    if (!level.getBlockState(checkPos).is(EBlocks.POTENT_SULFUR)) continue;

                    BlockState feetState = level.getBlockState(playerPos);
                    if (!feetState.getFluidState().isSourceOfType(Fluids.WATER)) continue;

                    if (PotentSulfurBlockEntity.haveLineOfSight(level, Vec3.atCenterOf(checkPos.above()), player.getEyePosition())) {
                        inAnySulfurPool = true;
                        break;
                    }
                }

                int id = player.getId();
                if (inAnySulfurPool) {
                    int ticks = timeInPool.getOrDefault(id, 0) + 10;
                    timeInPool.put(id, ticks);
                    player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 80, 0, true, true));
                    if (ticks >= TICKS_BEFORE_POISON) {
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, 80, 0, true, true));
                    }
                } else {
                    timeInPool.remove(id);
                }

                if (inAnySulfurPool) {
                    AABB searchArea = new AABB(playerPos).inflate(5, 3, 5);
                    for (LivingEntity mob : level.getEntitiesOfClass(LivingEntity.class, searchArea, e -> !(e instanceof Player))) {
                        BlockPos mobPos = mob.blockPosition();
                        if (!level.getBlockState(mobPos).getFluidState().isSourceOfType(Fluids.WATER)) continue;

                        for (BlockPos checkPos : BlockPos.betweenClosed(
                                mobPos.offset(-3, -5, -3),
                                mobPos.offset(3, 0, 3))) {
                            if (!level.getBlockState(checkPos).is(EBlocks.POTENT_SULFUR)) continue;
                            if (PotentSulfurBlockEntity.haveLineOfSight(level, Vec3.atCenterOf(checkPos.above()), mob.getEyePosition())) {
                                mob.addEffect(new MobEffectInstance(MobEffects.POISON, 80, 0, true, true));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}