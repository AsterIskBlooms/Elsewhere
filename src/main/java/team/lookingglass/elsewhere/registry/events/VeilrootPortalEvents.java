package team.lookingglass.elsewhere.registry.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import team.lookingglass.elsewhere.dimension.portal.VeilrootPortalShape;

import java.util.Optional;

public class VeilrootPortalEvents {
    public static void register() {
        UseBlockCallback.EVENT.register(VeilrootPortalEvents::onUseBlock);
    }

    private static InteractionResult onUseBlock(Player player, Level level, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) return InteractionResult.PASS;
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;

        BlockPos pos = hit.getBlockPos();
        BlockState state = level.getBlockState(pos);
        if (!state.is(Blocks.LAPIS_BLOCK)) return InteractionResult.PASS;

        ItemStack held = player.getItemInHand(hand);
        if (!held.is(Items.AMETHYST_SHARD)) return InteractionResult.PASS;

        Optional<VeilrootPortalShape> shape = VeilrootPortalShape.tryForm(level, pos);
        if (shape.isEmpty()) return InteractionResult.PASS;

        shape.get().createPortalBlocks(level);
        if (!player.getAbilities().instabuild) {
            held.shrink(1);
        }
        player.swing(hand);
        return InteractionResult.SUCCESS;
    }
}