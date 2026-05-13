package team.lookingglass.elsewhere.mixin;

import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = NoiseGeneratorSettings.class, remap = true)
public interface NoiseGeneratorSettingsAccessor {

    @Mutable
    @Accessor("surfaceRule")
    void setSurfaceRule(SurfaceRules.RuleSource surfaceRule);
}
