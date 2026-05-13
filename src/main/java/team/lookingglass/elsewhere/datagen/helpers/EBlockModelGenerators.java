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
        TextureMapping mapping = model.getMapping().put(TextureSlot.WALL, TextureMapping.getBlockTexture(block, "_side"));
        return new BlockFamilyProvider(model.getMapping()).fullBlock(block, model.getTemplate());
    }


    // Fuck me.
    public final void axisAlignedPillarFamily(
            final Block block,
            final TexturedModel.Provider pillarProvider,
            final Block stairs,
            final Block slab,
            final Block wall
    ) {

        // Base block — axis aligned pillar
        Identifier modelLocation = pillarProvider.create(block, this.modelOutput);
        this.blockStateOutput.accept(createAxisAlignedPillarBlock(block, plainVariant(modelLocation)));

        // Grab texture mapping from the pillar for sub-blocks
        TextureMapping mapping = pillarProvider.get(block).getMapping();

        // Stairs
        Identifier innerModel = ModelTemplates.STAIRS_INNER.create(stairs, mapping, this.modelOutput);
        Identifier straightModel = ModelTemplates.STAIRS_STRAIGHT.create(stairs, mapping, this.modelOutput);
        Identifier outerModel = ModelTemplates.STAIRS_OUTER.create(stairs, mapping, this.modelOutput);
        this.blockStateOutput.accept(createStairs(stairs,
                plainVariant(innerModel),
                plainVariant(straightModel),
                plainVariant(outerModel)));

        // Slab
        Identifier bottomModel = ModelTemplates.SLAB_BOTTOM.create(slab, mapping, this.modelOutput);
        Identifier topModel = ModelTemplates.SLAB_TOP.create(slab, mapping, this.modelOutput);
        this.blockStateOutput.accept(createSlab(slab,
                plainVariant(bottomModel),
                plainVariant(topModel),
                plainVariant(modelLocation)));

        // Wall
        TextureMapping wallMapping = new TextureMapping().put(TextureSlot.WALL, mapping.get(TextureSlot.SIDE));
        Identifier wallPostModel = ModelTemplates.WALL_POST.create(wall, wallMapping, this.modelOutput);
        Identifier wallLowModel = ModelTemplates.WALL_LOW_SIDE.create(wall, wallMapping, this.modelOutput);
        Identifier wallTallModel = ModelTemplates.WALL_TALL_SIDE.create(wall, wallMapping, this.modelOutput);
        this.blockStateOutput.accept(createWall(wall,
                plainVariant(wallPostModel),
                plainVariant(wallLowModel),
                plainVariant(wallTallModel)));
        Identifier inventory = ModelTemplates.WALL_INVENTORY.create(wall, wallMapping, this.modelOutput);
        this.registerSimpleItemModel(wall, inventory);
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