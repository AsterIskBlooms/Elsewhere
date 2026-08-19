package team.lookingglass.elsewhere.datagen.helpers;

import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EBlockModelGenerators extends BlockModelGenerators {
    private static final PropertyDispatch<VariantMutator> ROTATION_HORIZONTAL_FACING = PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
            .select(Direction.EAST, Y_ROT_90)
            .select(Direction.SOUTH, Y_ROT_180)
            .select(Direction.WEST, Y_ROT_270)
            .select(Direction.NORTH, NOP);

    public EBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    public static final ModelTemplate CUBE_ALL_DIRECTIONAL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block/cube_directional")),
            Optional.empty(),
            TextureSlot.ALL
    );
    public static final ModelTemplate CUBE_ALL_DIRECTIONAL_HORIZONTAL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block/cube_directional_horizontal")),
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

    public final void createWoodenBoards(final Block block) {
        MultiVariant model = plainVariant(CUBE_DIRECTIONAL.create(block, this.modelOutput));
        MultiVariant horizontalModel = plainVariant(CUBE_DIRECTIONAL_HORIZONTAL.create(block, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.AXIS)
                .select(Direction.Axis.Y, model)
                .select(Direction.Axis.Z, horizontalModel.with(X_ROT_90))
                .select(Direction.Axis.X, horizontalModel.with(X_ROT_90).with(Y_ROT_90))
        ));
    }

    public void createAridGrassBlock() {
        Material bottomTexture = TextureMapping.getBlockTexture(EBlocks.ARID_DIRT);
        TextureMapping snowyMapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, bottomTexture)
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.SNOW))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EBlocks.ARID_GRASS_BLOCK, "_snow"));

        MultiVariant aridSnowyGrass = createRotatedVariants(
                plainModel(ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(EBlocks.ARID_GRASS_BLOCK, "_snow", snowyMapping, modelOutput))
        );

        Identifier aridPlainGrassModel = ModelLocationUtils.getModelLocation(EBlocks.ARID_GRASS_BLOCK);
        MultiVariant aridPlainGrass = createRotatedVariants(plainModel(aridPlainGrassModel));

        createGrassLikeBlock(EBlocks.ARID_GRASS_BLOCK, aridPlainGrass, aridSnowyGrass);
        registerSimpleTintedItemModel(EBlocks.ARID_GRASS_BLOCK, aridPlainGrassModel, new GrassColorSource(1.0F, 0.0F));
    }

    public final void createRotatedVariantColumn(final Block block) {
        Variant normal = plainModel(TexturedModel.COLUMN.create(block, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, createRotatedVariants(normal)));
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

    public void createSeagrassSandBlock() {
        Material bottomTexture = TextureMapping.getBlockTexture(Blocks.SAND);

        TextureMapping mapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, bottomTexture)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(EBlocks.SEAGRASS_SAND, "_top"))
                .copyForced(TextureSlot.TOP, TextureSlot.PARTICLE)
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(EBlocks.SEAGRASS_SAND, "_side"));

        Variant normal = plainModel(
                ModelTemplates.CUBE_BOTTOM_TOP.create(EBlocks.SEAGRASS_SAND, mapping, this.modelOutput)
        );
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(EBlocks.SEAGRASS_SAND, createRotatedVariants(normal))
        );
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

    public final void createSimpleHorizontallyRotatedBlock(final Block block, final TexturedModel.Provider modelProvider) {
        MultiVariant model = plainVariant(modelProvider.create(block, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, model)
                .select(Direction.SOUTH, model)
                .select(Direction.EAST, model.with(Y_ROT_270))
                .select(Direction.WEST, model.with(Y_ROT_270))
        ));
    }

    public NetherrackFamilyProvider netherrackFamily(Block block) {
        TextureMapping mapping = TextureMapping.cube(block);
        Identifier model = ModelTemplates.CUBE_ALL.create(block, mapping, this.modelOutput);
        return new NetherrackFamilyProvider(model, mapping);
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


    public class NetherrackFamilyProvider {
        private final Identifier modelLocation;
        private final TextureMapping mapping;

        public NetherrackFamilyProvider(Identifier modelLocation, TextureMapping mapping) {
            this.modelLocation = modelLocation;
            this.mapping = mapping;
        }

        public NetherrackFamilyProvider stairs(Block stairs) {
            Identifier inner = ModelTemplates.STAIRS_INNER.create(stairs, mapping, modelOutput);
            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(stairs, mapping, modelOutput);
            Identifier outer = ModelTemplates.STAIRS_OUTER.create(stairs, mapping, modelOutput);

            blockStateOutput.accept(
                    createStairs(
                            stairs,
                            plainVariant(inner),
                            plainVariant(straight),
                            plainVariant(outer)
                    )
            );

            return this;
        }

        public NetherrackFamilyProvider slab(Block slab) {
            Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(slab, mapping, modelOutput);
            Identifier top = ModelTemplates.SLAB_TOP.create(slab, mapping, modelOutput);

            blockStateOutput.accept(
                    createSlab(
                            slab,
                            plainVariant(bottom),
                            plainVariant(top),
                            plainVariant(modelLocation)
                    )
            );

            return this;
        }

        public NetherrackFamilyProvider wall(Block wall) {
            TextureMapping wallMapping = new TextureMapping()
                    .put(TextureSlot.WALL, mapping.get(TextureSlot.ALL));

            Identifier post = ModelTemplates.WALL_POST.create(wall, wallMapping, modelOutput);
            Identifier low = ModelTemplates.WALL_LOW_SIDE.create(wall, wallMapping, modelOutput);
            Identifier tall = ModelTemplates.WALL_TALL_SIDE.create(wall, wallMapping, modelOutput);

            blockStateOutput.accept(
                    createWall(
                            wall,
                            plainVariant(post),
                            plainVariant(low),
                            plainVariant(tall)
                    )
            );

            registerSimpleItemModel(
                    wall,
                    ModelTemplates.WALL_INVENTORY.create(wall, wallMapping, modelOutput)
            );

            return this;
        }
    }

    public final void createEmissiveDoublePlantWithDefaultItem(final Block block, final PlantType plantType) {
        this.registerTwoLayerFlatItemModel(block, "_top", "_top_emissive");
        this.createEmissiveDoublePlant(block, plantType);
    }

    public final void createEmissiveDoublePlant(final Block block, final PlantType plantType) {
        MultiVariant topModel = plainVariant(this.createSuffixedVariant(block, "_top", plantType.getCross(),
                material -> (new TextureMapping())
                        .put(TextureSlot.CROSS, material)
                        .put(TextureSlot.CROSS_EMISSIVE, TextureMapping.getBlockTexture(block, "_top_emissive"))));
        MultiVariant bottomModel = plainVariant(this.createSuffixedVariant(block, "_bottom", plantType.getCross(),
                material -> (new TextureMapping())
                        .put(TextureSlot.CROSS, material)
                        .put(TextureSlot.CROSS_EMISSIVE, TextureMapping.getBlockTexture(block, "_bottom_emissive"))));
        this.createDoubleBlock(block, topModel, bottomModel);
    }

    public final void registerTwoLayerFlatItemModel(final Block block, final String baseSuffix, final String overlaySuffix) {
        Item blockItem = block.asItem();
        if (blockItem != Items.AIR) {
            Material base = TextureMapping.getBlockTexture(block, baseSuffix);
            Material overlay = TextureMapping.getBlockTexture(block, overlaySuffix);
            Identifier model = ModelTemplates.TWO_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(blockItem), TextureMapping.layered(base, overlay), this.modelOutput);
            this.registerSimpleItemModel(blockItem, model);
        }
    }
}