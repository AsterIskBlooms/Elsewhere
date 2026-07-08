package team.lookingglass.elsewhere.mixin.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeGenMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectOutback(CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        // Array is [0-4] row, [0-4] column

        ResourceKey<Biome>[][] middleA = accessor.getMiddleBiomes();
        ResourceKey<Biome>[][] middleB = accessor.getMiddleBiomesVariant();
        ResourceKey<Biome>[][] plateauA = accessor.getPlateauBiomes();
        ResourceKey<Biome>[][] plateauB = accessor.getPlateauBiomes();

        middleA[4][0] = EBiomes.OUTBACK;
        middleA[4][1] = EBiomes.OUTBACK;

        middleB[1][0] = EBiomes.TUNDRA;
        middleB[1][1] = EBiomes.TUNDRA;
        plateauB[1][1] = EBiomes.TUNDRA;

//        middleB[1][2] = EBiomes.DAPPLED_FOREST;
//        plateauB[1][2] = EBiomes.DAPPLED_FOREST;

    }

    @Inject(method = "addUndergroundBiomes", at = @At("TAIL"))
    private void injectCustomCaveBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes, CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        accessor.invokeAddUndergroundBiome(biomes,
                accessor.getFULL_RANGE(),
                Climate.Parameter.span(-1.0F, 0.7F),
                Climate.Parameter.span(-1.05F, 0.8F),
                Climate.Parameter.span(0.775F, 1.0F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.CRYSTAL_CAVERNS
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(-1.0F, 0.2F),
                accessor.getFULL_RANGE(),
                Climate.Parameter.span(0.03F, 0.8F),
                Climate.Parameter.span(0.45F, 0.55F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.SULFUR_CAVES
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(-1.0F, -0.45F),
                Climate.Parameter.span(-1.0F, 0.1F),
                Climate.Parameter.span(0.3F, 0.8F),
                Climate.Parameter.span(-1.0F, 0.45F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.FRIGID_CAVES
        );
    }
}