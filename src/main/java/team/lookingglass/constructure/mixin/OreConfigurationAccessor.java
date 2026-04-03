package team.lookingglass.constructure.mixin;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(OreConfiguration.class)
public interface OreConfigurationAccessor {

    @Mutable
    @Accessor("targetStates")
    void setTargetStates(List<OreConfiguration.TargetBlockState> targetStates);
}
