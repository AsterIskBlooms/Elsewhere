package team.lookingglass.elsewhere.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeGenMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectOutback(CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        // replace some desert slots with outback
        ResourceKey<Biome>[][] middle = accessor.getMiddleBiomes();
        middle[4][0] = EBiomes.OUTBACK; // hot, dry, near inland
        middle[4][1] = EBiomes.OUTBACK; // hot, dry, mid inland

        // replace some plateau desert/badlands slots
        ResourceKey<Biome>[][] plateau = accessor.getPlateauBiomes();
        plateau[4][0] = EBiomes.OUTBACK;
        plateau[4][1] = EBiomes.OUTBACK;
    }

    @Inject(method = "addUndergroundBiomes", at = @At("TAIL"))
    private void injectCrystallineCaves(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes, CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        accessor.invokeAddUndergroundBiome(biomes,
                accessor.getFULL_RANGE(), // temperature — any
                accessor.getFULL_RANGE(), // humidity — any
                Climate.Parameter.span(-1.20F, -0.455F), // continentalness — ocean
                Climate.Parameter.span(0.55F, 1.0F), // erosion — eroded
                accessor.getFULL_RANGE(), // weirdness — any
                0.0F,
                EBiomes.CRYSTAL_CAVERNS
        );
        accessor.invokeAddUndergroundBiome(biomes,
                accessor.getFULL_RANGE(), // temperature — any
                accessor.getFULL_RANGE(), // humidity — any
                accessor.getFULL_RANGE(), // continentalness — any
                accessor.getFULL_RANGE(), // erosion — any
                Climate.Parameter.span(-1.0F, -0.767F), // weirdness — low
                0.0F,
                EBiomes.SULFUR_CAVES
        );
//        this.addShallowUndergroundBiome(biomes,
//                Climate.Parameter.span(0.55F, 1.0F), // temperature — hot
//                accessor.getFULL_RANGE(), // humidity — any
//                Climate.Parameter.span(0.3F, 1.0F), // continentalness — far inland
//                accessor.getFULL_RANGE(), // erosion — any
//                accessor.getFULL_RANGE(), // weirdness — any
//                0.0F,
//                EBiomes.ARID_CAVES
//        );
        this.addShallowUndergroundBiome(biomes,
                Climate.Parameter.span(-1.0F, -0.45F), // temperature — cold
                Climate.Parameter.span(-1.0F, 0.3F), // humidity — low
                Climate.Parameter.span(-0.11F, 1.0F), // continentalness — inland
                accessor.getFULL_RANGE(), // erosion — any
                accessor.getFULL_RANGE(), // weirdness — any
                0.0F,
                EBiomes.FRIGID_CAVES
        );
    }

    @Unique
    private void addShallowUndergroundBiome(final Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes, final Climate.Parameter temperature, final Climate.Parameter humidity,
                                            final Climate.Parameter continentalness, final Climate.Parameter erosion, final Climate.Parameter weirdness, final float offset, final ResourceKey<Biome> biome) {
        biomes.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.1F, 0.2F), weirdness, offset), biome));
    }
}
