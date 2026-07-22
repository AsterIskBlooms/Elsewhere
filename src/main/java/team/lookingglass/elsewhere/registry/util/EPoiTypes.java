package team.lookingglass.elsewhere.registry.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.Set;

public class EPoiTypes {
    public static final ResourceKey<PoiType> VEILROOT_PORTAL = ResourceKey.create(
            Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot_portal"));

    public static void initialize() {
        Set<BlockState> states = ImmutableSet.copyOf(EBlocks.VEILROOT_PORTAL.getStateDefinition().getPossibleStates());
        PoiType poiType = new PoiType(states, 0, 1);
        Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, VEILROOT_PORTAL, poiType);
    }
}
