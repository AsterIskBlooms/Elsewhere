package team.lookingglass.elsewhere.registry.blocktypes;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

public class EBlockEntityTypes {

    public static final BlockEntityType<PotentSulfurBlockEntity> POTENT_SULFUR =
            register("potent_sulfur", PotentSulfurBlockEntity::new, EBlocks.POTENT_SULFUR);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block... validBlocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(Elsewhere.MODID, name),
                FabricBlockEntityTypeBuilder.create(factory, validBlocks).build());
    }

    public static void initialize() {
        BlockEntityType.SIGN.addValidBlock(EBlocks.POPLAR_SIGN);
        BlockEntityType.SIGN.addValidBlock(EBlocks.POPLAR_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(EBlocks.POPLAR_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(EBlocks.POPLAR_WALL_HANGING_SIGN);

        BlockEntityType.SIGN.addValidBlock(EBlocks.AZALEA_SIGN);
        BlockEntityType.SIGN.addValidBlock(EBlocks.AZALEA_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(EBlocks.AZALEA_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(EBlocks.AZALEA_WALL_HANGING_SIGN);
    }
}
