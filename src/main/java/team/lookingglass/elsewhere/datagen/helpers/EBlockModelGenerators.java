package team.lookingglass.elsewhere.datagen.helpers;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EBlockModelGenerators extends BlockModelGenerators {

    public EBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    public BlockFamilyProvider columnFamily(Block block) {
        TexturedModel model = TexturedModel.COLUMN.get(block);
        TextureMapping mapping = model.getMapping()
                .put(TextureSlot.WALL, model.getMapping().get(TextureSlot.SIDE));
        return new BlockFamilyProvider(mapping).fullBlock(block, model.getTemplate());
    }

    public BlockFamilyProvider cubeTopFamily(Block block) {
        TexturedModel model = TexturedModel.CUBE_TOP.get(block);
        TextureMapping mapping = model.getMapping()
                .put(TextureSlot.WALL, TextureMapping.getBlockTexture(block, "_side"))
                .put(TextureSlot.BOTTOM, model.getMapping().get(TextureSlot.SIDE));
        return new BlockFamilyProvider(mapping).fullBlock(block, model.getTemplate());
    }

    public BlockFamilyProvider cubeTopBottomFamily(Block block) {
        TexturedModel model = TexturedModel.CUBE_TOP_BOTTOM.get(block);
        TextureMapping mapping = model.getMapping()
                .put(TextureSlot.WALL, TextureMapping.getBlockTexture(block, "_side"))
                .put(TextureSlot.BOTTOM, model.getMapping().get(TextureSlot.BOTTOM));
        return new BlockFamilyProvider(mapping).fullBlock(block, model.getTemplate());
    }


    // Fuck me.
    public AxisAlignedPillarFamilyProvider axisAlignedPillarFamily(Block block, TexturedModel.Provider pillarProvider) {
        Identifier modelLocation = pillarProvider.create(block, this.modelOutput);
        this.blockStateOutput.accept(createAxisAlignedPillarBlock(block, plainVariant(modelLocation)));
        TextureMapping mapping = pillarProvider.get(block).getMapping();
        return new AxisAlignedPillarFamilyProvider(modelLocation, mapping);
    }

    public class AxisAlignedPillarFamilyProvider {
        private final Identifier modelLocation;
        private final TextureMapping mapping;

        public AxisAlignedPillarFamilyProvider(Identifier modelLocation, TextureMapping mapping) {
            this.modelLocation = modelLocation;
            this.mapping = mapping;
        }

        public AxisAlignedPillarFamilyProvider stairs(Block stairs) {
            Identifier innerModel = ModelTemplates.STAIRS_INNER.create(stairs, mapping, modelOutput);
            Identifier straightModel = ModelTemplates.STAIRS_STRAIGHT.create(stairs, mapping, modelOutput);
            Identifier outerModel = ModelTemplates.STAIRS_OUTER.create(stairs, mapping, modelOutput);
            blockStateOutput.accept(createStairs(stairs,
                    plainVariant(innerModel),
                    plainVariant(straightModel),
                    plainVariant(outerModel)));
            return this;
        }

        public AxisAlignedPillarFamilyProvider slab(Block slab) {
            Identifier bottomModel = ModelTemplates.SLAB_BOTTOM.create(slab, mapping, modelOutput);
            Identifier topModel = ModelTemplates.SLAB_TOP.create(slab, mapping, modelOutput);
            blockStateOutput.accept(createSlab(slab,
                    plainVariant(bottomModel),
                    plainVariant(topModel),
                    plainVariant(modelLocation)));
            return this;
        }

        public AxisAlignedPillarFamilyProvider wall(Block wall) {
            TextureMapping wallMapping = new TextureMapping().put(TextureSlot.WALL, mapping.get(TextureSlot.SIDE));
            Identifier wallPostModel = ModelTemplates.WALL_POST.create(wall, wallMapping, modelOutput);
            Identifier wallLowModel = ModelTemplates.WALL_LOW_SIDE.create(wall, wallMapping, modelOutput);
            Identifier wallTallModel = ModelTemplates.WALL_TALL_SIDE.create(wall, wallMapping, modelOutput);
            blockStateOutput.accept(createWall(wall,
                    plainVariant(wallPostModel),
                    plainVariant(wallLowModel),
                    plainVariant(wallTallModel)));
            Identifier inventory = ModelTemplates.WALL_INVENTORY.create(wall, wallMapping, modelOutput);
            registerSimpleItemModel(wall, inventory);
            return this;
        }
    }

    public void generateStalactite(BlockModelGenerators generator, Block sulfurBlock) {
        PropertyDispatch.C2<MultiVariant, Direction, DripstoneThickness> dispatch =
                PropertyDispatch.initial(BlockStateProperties.VERTICAL_DIRECTION, BlockStateProperties.DRIPSTONE_THICKNESS);

        for (Direction dir : Direction.values()) {
            if (dir.getAxis().isVertical()) {
                for (DripstoneThickness thick : DripstoneThickness.values()) {
                    dispatch.select(dir, thick, createStalactiteVariant(generator, sulfurBlock, dir, thick));
                }
            }
        }

        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(sulfurBlock).with(dispatch));
    }

    public final MultiVariant createStalactiteVariant(BlockModelGenerators generator, Block block, Direction direction, DripstoneThickness thickness) {
        String suffix = "_" + direction.getSerializedName() + "_" + thickness.getSerializedName();

        TextureMapping texture = new TextureMapping()
                .put(TextureSlot.CROSS, TextureMapping.getBlockTexture(block, suffix));

        return BlockModelGenerators.plainVariant(
                ModelTemplates.POINTED_DRIPSTONE.createWithSuffix(
                        block,
                        suffix,
                        texture,
                        generator.modelOutput
                )
        );
    }


}