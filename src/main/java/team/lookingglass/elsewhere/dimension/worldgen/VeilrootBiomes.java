package team.lookingglass.elsewhere.dimension.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VeilrootBiomes {
    private static final Climate.Parameter fullRange = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter noWeirdness = Climate.Parameter.point(0.0F);

    private static final Climate.Parameter contDEPTH = Climate.Parameter.span(-1.0F, -0.55F);
    private static final Climate.Parameter contFLAT = Climate.Parameter.span(-0.55F, -0.3F);
    private static final Climate.Parameter contPLAT = Climate.Parameter.span(-0.3F, 0.25F);
    private static final Climate.Parameter contDIPS = Climate.Parameter.span(0.25F, 1.0F);

    private static final Climate.Parameter erosCANYONS = Climate.Parameter.span(0.6F, 1.0F);

    private static final Climate.Parameter tempHOT = Climate.Parameter.span(0.35F, 1.0F);
    private static final Climate.Parameter tempWARM = Climate.Parameter.span(-0.2F, 0.35F);
    private static final Climate.Parameter tempCOLD = Climate.Parameter.span(-1.0F, -0.2F);

    private static final Climate.Parameter vegLUSH = Climate.Parameter.span(0.235F, 1.0F);
    private static final Climate.Parameter vegREG = Climate.Parameter.span(-0.55F, 0.235F);
    private static final Climate.Parameter vegDRY = Climate.Parameter.span(-1.0F, -0.55F);

    private static final Climate.Parameter[] TEMPERATURE = { tempCOLD, tempWARM, tempHOT };
    private static final Climate.Parameter[] VEGETATION = { vegDRY, vegREG, vegLUSH };

    private static final ResourceKey<Biome>[][] DEPTH_BIOMES = new ResourceKey[][]{
            { EBiomes.FROSTED_CRAG, EBiomes.FROSTED_JUNGLE, EBiomes.FROSTED_JUNGLE },
            { EBiomes.ROTTEN_GROVE, EBiomes.VEILED_FOREST, EBiomes.VEILED_FOREST },
            { EBiomes.ROTTEN_GROVE, EBiomes.BROUSH_FOREST, EBiomes.BROUSH_FOREST }
    };

    private static final ResourceKey<Biome>[][] FLAT_BIOMES = new ResourceKey[][]{
            { EBiomes.FROSTED_CRAG, EBiomes.FROSTED_CRAG, EBiomes.FROSTED_JUNGLE },
            { EBiomes.ROTTEN_GROVE, EBiomes.VEILED_FOREST, EBiomes.VEILED_FOREST },
            { EBiomes.SWEEPING_SANDS, EBiomes.ROTTEN_GROVE, EBiomes.ROTTEN_GROVE }
    };

    private static final ResourceKey<Biome>[][] PLAT_BIOMES = new ResourceKey[][]{
            { EBiomes.FROSTED_CRAG, EBiomes.FROSTED_CRAG, EBiomes.FROSTED_JUNGLE },
            { EBiomes.ROTTEN_GROVE, EBiomes.ROTTEN_GROVE, EBiomes.VEILED_FOREST },
            { EBiomes.SWEEPING_SANDS, EBiomes.SWEEPING_SANDS, EBiomes.SWEEPING_SANDS }
    };

    private static final ResourceKey<Biome>[][] DIPS_BIOMES = new ResourceKey[][]{
            { EBiomes.FROSTED_CRAG, EBiomes.FROSTED_JUNGLE, EBiomes.FROSTED_JUNGLE },
            { EBiomes.ROTTEN_GROVE, EBiomes.BROUSH_FOREST, EBiomes.BROUSH_FOREST },
            { EBiomes.SWEEPING_SANDS, EBiomes.BROUSH_FOREST, EBiomes.BROUSH_FOREST }
    };

    public static MultiNoiseBiomeSource biomeSource(HolderGetter<Biome> biomes) {
        List<Pair<Climate.ParameterPoint, Holder<Biome>>> entries = new ArrayList<>();

        addRegion(entries::add, biomes, contDEPTH, DEPTH_BIOMES);
        addRegion(entries::add, biomes, contFLAT, FLAT_BIOMES);
        addRegion(entries::add, biomes, contPLAT, PLAT_BIOMES);
        addRegion(entries::add, biomes, contDIPS, DIPS_BIOMES);
        addErosionBand(entries::add, biomes, erosCANYONS, EBiomes.BROOD_CANYON);

        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(entries));
    }

    private static void addRegion(Consumer<Pair<Climate.ParameterPoint, Holder<Biome>>> output, HolderGetter<Biome> biomes,
                                  Climate.Parameter continentalness, ResourceKey<Biome>[][] table) {
        for (int temperature = 0; temperature < TEMPERATURE.length; temperature++) {
            for (int vegetation = 0; vegetation < VEGETATION.length; vegetation++) {
                ResourceKey<Biome> biome = table[temperature][vegetation];
                output.accept(Pair.of(
                        Climate.parameters(
                                TEMPERATURE[temperature],
                                VEGETATION[vegetation],
                                continentalness,
                                fullRange,
                                noWeirdness,
                                noWeirdness,
                                0.0F),
                        biomes.getOrThrow(biome)
                ));
            }
        }
    }

    private static void addErosionBand(Consumer<Pair<Climate.ParameterPoint, Holder<Biome>>> output, HolderGetter<Biome> biomes,
                                       Climate.Parameter erosion, ResourceKey<Biome> biome) {
        output.accept(Pair.of(
                Climate.parameters(
                        fullRange,
                        fullRange,
                        fullRange,
                        erosion,
                        noWeirdness,
                        noWeirdness,
                        0.0F),
                biomes.getOrThrow(biome)
        ));
    }
}