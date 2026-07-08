package team.lookingglass.elsewhere.registry.blocktypes;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

public class AridGrassBlock extends SpreadingSnowyBlock {

    public static final MapCodec<AridGrassBlock> CODEC = simpleCodec(AridGrassBlock::new);

    public AridGrassBlock(BlockBehaviour.Properties properties) {
        super(properties, EBlocks.ARID_DIRT_KEY);
    }

    @Override
    protected MapCodec<AridGrassBlock> codec() {
        return CODEC;
    }
}