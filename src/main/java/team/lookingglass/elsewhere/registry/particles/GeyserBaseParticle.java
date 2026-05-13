package team.lookingglass.elsewhere.registry.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;

public class GeyserBaseParticle extends SingleQuadParticle {

    protected GeyserBaseParticle(ClientLevel level, double x, double y, double z,
                                 double xa, double ya, double za, GeyserBaseParticleOptions options, SpriteSet sprites) {
        super(level, x, y, z, xa, ya, za, sprites.first());
        this.setSpriteFromAge(sprites);
        this.lifetime = 20;
        this.hasPhysics = true;
        if (options.burstImpulseBase() == 2.0F) {
            this.quadSize *= 3.0F; // POOF
        } else this.quadSize = 0.75F;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<GeyserBaseParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public @Nullable Particle createParticle(GeyserBaseParticleOptions options,
                                                 ClientLevel level, double x, double y, double z,
                                                 double xAux, double yAux, double zAux, RandomSource random) {
            return new GeyserBaseParticle(level, x, y, z, xAux, yAux, zAux, options, sprites);
        }
    }
}
