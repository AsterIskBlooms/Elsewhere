package team.lookingglass.constructure.registry;

import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import team.lookingglass.constructure.datagen.BlockTagProvider;
import team.lookingglass.constructure.mixin.NoiseGeneratorSettingsAccessor;
import team.lookingglass.constructure.mixin.OreConfigurationAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CWorldgen {

    public static void initialize() {
        DynamicRegistrySetupCallback.EVENT.register(registryView -> {
            registryView.registerEntryAdded(Registries.NOISE_SETTINGS, (rawId, id, object) -> {
                System.out.println("NOISE SETTINGS ENTRY: " + id);
                if (!id.equals(Identifier.withDefaultNamespace("overworld"))) return;
                System.out.println("OVERWORLD FOUND - applying shale rules");

                // Shale fades in between 32 and 24, fades out between -8 and -16
                SurfaceRules.RuleSource shaleRule = SurfaceRules.ifTrue(
                        SurfaceRules.not(
                                SurfaceRules.verticalGradient("constructure:shale_bottom",
                                        VerticalAnchor.absolute(-16),
                                        VerticalAnchor.absolute(-8))
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.verticalGradient("constructure:shale_top",
                                        VerticalAnchor.absolute(24),
                                        VerticalAnchor.absolute(32)),
                                SurfaceRules.state(CBlocks.SHALE.defaultBlockState())
                        )
                );

                // Deepslate fades in between -8 and -16
                SurfaceRules.RuleSource deepslateRule = SurfaceRules.ifTrue(
                        SurfaceRules.verticalGradient("minecraft:deepslate",
                                VerticalAnchor.absolute(-16),
                                VerticalAnchor.absolute(-8)),
                        SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                );

                SurfaceRules.RuleSource newRules = SurfaceRules.sequence(
                        deepslateRule,
                        shaleRule,
                        object.surfaceRule()
                );

                ((NoiseGeneratorSettingsAccessor)(Object) object).setSurfaceRule(newRules);
            });

            registryView.registerEntryAdded(Registries.CONFIGURED_FEATURE, (_, _, object) -> {
                if (!(object.feature() == Feature.ORE)) return;
                if (!(object.config() instanceof OreConfiguration config)) return;

                List<OreConfiguration.TargetBlockState> targets = new ArrayList<>(config.targetStates);

                Optional<Block> matchedBlock = targets.stream()
                        .map(t -> t.state.getBlock())
                        .filter(b -> b == Blocks.IRON_ORE || b == Blocks.GOLD_ORE
                                || b == Blocks.DIAMOND_ORE || b == Blocks.LAPIS_ORE
                                || b == Blocks.COPPER_ORE || b == Blocks.COAL_ORE
                                || b == Blocks.EMERALD_ORE || b == Blocks.REDSTONE_ORE)
                        .findFirst();

                if (matchedBlock.isEmpty()) return;

                BlockState shaleOreState = switch (matchedBlock.get()) {
                    case Block b when b == Blocks.IRON_ORE -> CBlocks.SHALE_IRON_ORE.defaultBlockState();
                    case Block b when b == Blocks.GOLD_ORE -> CBlocks.SHALE_GOLD_ORE.defaultBlockState();
                    case Block b when b == Blocks.DIAMOND_ORE -> CBlocks.SHALE_DIAMOND_ORE.defaultBlockState();
                    case Block b when b == Blocks.LAPIS_ORE -> CBlocks.SHALE_LAPIS_ORE.defaultBlockState();
                    case Block b when b == Blocks.COPPER_ORE -> CBlocks.SHALE_COPPER_ORE.defaultBlockState();
                    case Block b when b == Blocks.COAL_ORE -> CBlocks.SHALE_COAL_ORE.defaultBlockState();
                    case Block b when b == Blocks.EMERALD_ORE -> CBlocks.SHALE_EMERALD_ORE.defaultBlockState();
                    case Block b when b == Blocks.REDSTONE_ORE -> CBlocks.SHALE_REDSTONE_ORE.defaultBlockState();
                    default -> null;
                };

                if (shaleOreState == null) return;

                targets.add(OreConfiguration.target(
                        new TagMatchTest(BlockTagProvider.SHALE_ORE_REPLACABLES),
                        shaleOreState
                ));

                ((OreConfigurationAccessor)(Object) config).setTargetStates(List.copyOf(targets));
            });
        });
    }
}