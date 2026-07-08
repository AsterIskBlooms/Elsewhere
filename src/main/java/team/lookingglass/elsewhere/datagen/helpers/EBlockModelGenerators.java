package team.lookingglass.elsewhere.datagen.helpers;

import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.blocktypes.PebbleBlock;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EBlockModelGenerators extends BlockModelGenerators {
    public EBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    public static final ModelTemplate CUBE_MIRRORED_HORIZONTAL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block/cube_mirrored_horizontal")),
            Optional.empty(),
            TextureSlot.ALL
    );

    public static final ModelTemplate CUBE_ALL_DIRECTIONAL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block/cube_directional")),
            Optional.empty(),
            TextureSlot.ALL
    );
    public static final ModelTemplate CUBE_ALL_DIRECTIONAL_HORIZONTAL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block/cube_directional")),
            Optional.of("_horizontal"),
            TextureSlot.ALL
    );
    public static final TexturedModel.Provider CUBE_DIRECTIONAL = TexturedModel.createDefault(
            block -> new TextureMapping().put(TextureSlot.ALL, TextureMapping.getBlockTexture(block)),
            CUBE_ALL_DIRECTIONAL
    );
    public static final TexturedModel.Provider CUBE_DIRECTIONAL_HORIZONTAL = TexturedModel.createDefault(
            block -> new TextureMapping().put(TextureSlot.ALL, TextureMapping.getBlockTexture(block)),
            CUBE_ALL_DIRECTIONAL_HORIZONTAL
    );

     public void createAridGrassBlock() {
         Material bottomTexture = TextureMapping.getBlockTexture(EBlocks.ARID_DIRT);
         TextureMapping snowyMapping = new TextureMapping()
                 .put(TextureSlot.BOTTOM, bottomTexture)
                 .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                 .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.SNOW))
                 .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EBlocks.ARID_GRASS_BLOCK, "_snow"));

        MultiVariant aridSnowyGrass = plainVariant(
                ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(EBlocks.ARID_GRASS_BLOCK, "_snow", snowyMapping, modelOutput)
        );

        Identifier aridPlainGrassModel = ModelLocationUtils.getModelLocation(EBlocks.ARID_GRASS_BLOCK);
        createGrassLikeBlock(EBlocks.ARID_GRASS_BLOCK, plainVariant(aridPlainGrassModel), aridSnowyGrass);
        registerSimpleTintedItemModel(EBlocks.ARID_GRASS_BLOCK, aridPlainGrassModel, new GrassColorSource(1.0F, 0.0F));
    }

    public void createTundraGrassBlock() {
        Material bottomTexture = TextureMapping.getBlockTexture(Blocks.DIRT);

        TextureMapping normalMapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, bottomTexture)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(EBlocks.RED_GRASS_BLOCK, "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EBlocks.RED_GRASS_BLOCK, "_side"));

        TextureMapping snowyMapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, bottomTexture)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.SNOW))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EBlocks.RED_GRASS_BLOCK, "_snow"));

        MultiVariant normalModel = createRotatedVariants(
                plainModel(ModelTemplates.CUBE_BOTTOM_TOP.create(EBlocks.RED_GRASS_BLOCK, normalMapping, this.modelOutput))
        );
        MultiVariant snowyModel = createRotatedVariants(
                plainModel(ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(EBlocks.RED_GRASS_BLOCK, "_snow", snowyMapping, this.modelOutput))
        );

        createGrassLikeBlock(EBlocks.RED_GRASS_BLOCK, normalModel, snowyModel);
    }

    public final void createPlantWithUniquePottedTexture(final Block standAlone, final Block potted, final PlantType plantType) {
        this.registerSimpleItemModel(standAlone.asItem(), plantType.createItemModel(this, standAlone));

        this.createCrossBlock(standAlone, plantType);

        Identifier standAloneId = BuiltInRegistries.BLOCK.getKey(standAlone);
        Identifier pottedId = standAloneId.withPath(path -> "potted_" + path);
        Material pottedTexture = new Material(pottedId.withPrefix("block/"));

        TextureMapping pottedTextures = TextureMapping.singleSlot(TextureSlot.PLANT, pottedTexture);
        MultiVariant model = plainVariant(plantType.getCrossPot().create(potted, pottedTextures, this.modelOutput));
        this.blockStateOutput.accept(createSimpleBlock(potted, model));
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

    public final void createWoodenBoards(final Block block) {
        MultiVariant model = plainVariant(CUBE_DIRECTIONAL.create(block, this.modelOutput));
        MultiVariant horizontalModel = plainVariant(CUBE_DIRECTIONAL_HORIZONTAL.create(block, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.AXIS)
                .select(Direction.Axis.Y, model)
                .select(Direction.Axis.Z, horizontalModel.with(X_ROT_90))
                .select(Direction.Axis.X, horizontalModel.with(X_ROT_90).with(Y_ROT_270))
        ));
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

    public void generatePebble(Block block) {
        PropertyDispatch.C1<MultiVariant, Integer> dispatch =
                PropertyDispatch.initial(PebbleBlock.COUNT);
        for (int count = 1; count <= 4; count++) {
            dispatch.select(count, plainVariant(ModelLocationUtils.getModelLocation(block, "_" + count)));
        }

        PropertyDispatch<VariantMutator> facingDispatch = PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, NOP)
                .select(Direction.EAST, Y_ROT_90)
                .select(Direction.SOUTH, Y_ROT_180)
                .select(Direction.WEST, Y_ROT_270);

        blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(dispatch)
                .with(facingDispatch));
    }


}