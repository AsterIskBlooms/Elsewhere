package team.lookingglass.elsewhere.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
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
                Climate.Parameter.span(-1.0F, -0.567F), // weirdness — low
                0.0F,
                EBiomes.SULFUR_CAVES
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(0.55F, 1.0F), // temperature — hot
                accessor.getFULL_RANGE(), // humidity — any
                accessor.getFULL_RANGE(), // continentalness — any
                Climate.Parameter.span(-1.0F, -0.375F), // erosion — low
                accessor.getFULL_RANGE(), // weirdness — low
                0.0F,
                EBiomes.ARID_CAVES
        );
    }
}
