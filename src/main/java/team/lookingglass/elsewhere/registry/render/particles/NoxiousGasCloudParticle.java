package team.lookingglass.elsewhere.registry.render.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.NoRenderParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import team.lookingglass.elsewhere.registry.render.EParticles;
import team.lookingglass.elsewhere.registry.blocktypes.PotentSulfurBlockEntity;

public class NoxiousGasCloudParticle extends NoRenderParticle {
    private static final int PARTICLE_TICKS = 2;

    protected NoxiousGasCloudParticle(final ClientLevel level, final double x, final double y, final double z, final SpriteSet spriteSet) {
        super(level, x, y, z);
        this.lifetime = 20;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age % 2 == 0) {
            BlockPos sourceBlock = BlockPos.containing(this.x, this.y, this.z);
            Vec3 particlePos = pickRandomParticleSpawnPoint(this.level, sourceBlock);
            if (PotentSulfurBlockEntity.canBeReachedByNoxiousGas(this.level, sourceBlock, particlePos)) {
                spawnNoxiousGasParticle(this.level, particlePos);
            }
        }
    }

    private static Vec3 pickRandomParticleSpawnPoint(final Level level, final BlockPos centerBlock) {
        RandomSource random = level.getRandom();
        Vec3 horizontalDirection = new Vec3(random.nextFloat() - 0.5F, 0.0, random.nextFloat() - 0.5F).normalize();
        float distance = random.nextFloat() * 3.0F;
        return Vec3.atCenterOf(centerBlock).add(horizontalDirection.scale(distance)).subtract(0.0, 0.25, 0.0);
    }

    private static void spawnNoxiousGasParticle(final Level level, final Vec3 pos) {
        level.addAlwaysVisibleParticle(EParticles.NOXIOUS_GAS, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public @Nullable Particle createParticle(
                SimpleParticleType options,
                ClientLevel level,
                double x, double y, double z,
                double xAux, double yAux, double zAux,
                RandomSource random
        ) {
            return new NoxiousGasCloudParticle(level, x, y, z, this.sprites);
        }
    }
}

