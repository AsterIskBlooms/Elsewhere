package team.lookingglass.elsewhere.worldgen.features.spike.utils;

import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import team.lookingglass.elsewhere.registry.blocktypes.SpikeBlock;

public record SpikeBlockSet(Block baseBlock, Block spikeBlock, TagKey<Block> replaceableTag) {

    public BlockState createSpikeState(Direction direction, DripstoneThickness thickness) {
        return spikeBlock.defaultBlockState()
                .setValue(SpikeBlock.TIP_DIRECTION, direction)
                .setValue(SpikeBlock.THICKNESS, thickness);
    }

    public BlockState defaultBaseState() {
        return baseBlock.defaultBlockState();
    }
}