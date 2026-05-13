package team.lookingglass.elsewhere.registry;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import team.lookingglass.elsewhere.registry.properties.PotentSulfurState;

public class EBlockStateProperties {
    public static final EnumProperty<PotentSulfurState> POTENT_SULFUR_STATE = EnumProperty.create("potent_sulfur_state", PotentSulfurState.class);
}
