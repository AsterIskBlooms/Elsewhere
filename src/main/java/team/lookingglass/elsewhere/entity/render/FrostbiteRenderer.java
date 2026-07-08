package team.lookingglass.elsewhere.entity.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;

@Environment(EnvType.CLIENT)
public class FrostbiteRenderer extends ZombieRenderer {
    private static final Identifier FROSTBITE_LOCATION = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/zombie/frostbite.png");
    private static final Identifier BABY_FROSTBITE_LOCATION = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/zombie/frostbite_baby.png");

    public FrostbiteRenderer(final EntityRendererProvider.Context context) {
        super(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_BABY, ModelLayers.ZOMBIE_ARMOR, ModelLayers.ZOMBIE_BABY_ARMOR);
    }

    @Override
    public Identifier getTextureLocation(final ZombieRenderState state) {
        return state.isBaby ? BABY_FROSTBITE_LOCATION : FROSTBITE_LOCATION;
    }
}