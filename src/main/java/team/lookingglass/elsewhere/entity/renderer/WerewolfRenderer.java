package team.lookingglass.elsewhere.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.Werewolf;
import team.lookingglass.elsewhere.entity.renderer.states.WerewolfRenderState;

@Environment(EnvType.CLIENT)
public class WerewolfRenderer extends HumanoidMobRenderer<Werewolf, WerewolfRenderState, ZombieModel<WerewolfRenderState>> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/werewolf/werewolf.png");

    public WerewolfRenderer(final EntityRendererProvider.Context context) {
        super(
                context,
                new ZombieModel<>(context.bakeLayer(ModelLayers.ZOMBIE)),
                new ZombieModel<>(context.bakeLayer(ModelLayers.ZOMBIE_BABY)),
                0.5F
        );
        ArmorModelSet<ZombieModel<WerewolfRenderState>> armorSet = ArmorModelSet.bake(ModelLayers.ZOMBIE_ARMOR, context.getModelSet(), ZombieModel::new);
        ArmorModelSet<ZombieModel<WerewolfRenderState>> babyArmorSet = ArmorModelSet.bake(ModelLayers.ZOMBIE_BABY_ARMOR, context.getModelSet(), ZombieModel::new);
        this.addLayer(new HumanoidArmorLayer<>(this, armorSet, babyArmorSet, context.getEquipmentRenderer()));
    }

    @Override
    public Identifier getTextureLocation(final WerewolfRenderState state) {
        return TEXTURE;
    }

    @Override
    public WerewolfRenderState createRenderState() {
        return new WerewolfRenderState();
    }

    @Override
    public void extractRenderState(final Werewolf entity, final WerewolfRenderState state, final float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.isAggressive = entity.isAggressive();
        state.isConverting = false;
    }
}