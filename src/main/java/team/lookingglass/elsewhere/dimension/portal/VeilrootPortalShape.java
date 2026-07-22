package team.lookingglass.elsewhere.dimension.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.Optional;

public class VeilrootPortalShape {
    public static final int MIN_WIDTH = 2;
    public static final int MAX_WIDTH = 21;
    public static final int MIN_HEIGHT = 2;
    public static final int MAX_HEIGHT = 21;

    private final Direction rightDir;
    private final BlockPos bottomLeft;
    private final int width;
    private final int height;

    private VeilrootPortalShape(Direction rightDir, BlockPos bottomLeft, int width, int height) {
        this.rightDir = rightDir;
        this.bottomLeft = bottomLeft;
        this.width = width;
        this.height = height;
    }

    public static Optional<VeilrootPortalShape> tryForm(LevelAccessor level, BlockPos interactPos) {
        Optional<VeilrootPortalShape> east = tryFormAxis(level, interactPos, Direction.EAST);
        if (east.isPresent()) return east;
        return tryFormAxis(level, interactPos, Direction.SOUTH);
    }

    private static Optional<VeilrootPortalShape> tryFormAxis(LevelAccessor level, BlockPos interactPos, Direction rightDir) {
        Direction leftDir = rightDir.getOpposite();

        BlockPos.MutableBlockPos scan = interactPos.mutable();
        while (level.getBlockState(scan.relative(leftDir)).is(Blocks.LAPIS_BLOCK)) {
            scan.move(leftDir);
        }
        BlockPos bottomLeft = scan.immutable();

        scan.set(interactPos);
        while (level.getBlockState(scan.relative(rightDir)).is(Blocks.LAPIS_BLOCK)) {
            scan.move(rightDir);
        }
        BlockPos bottomRight = scan.immutable();

        int width = bottomLeft.distManhattan(bottomRight) + 1;
        if (width < MIN_WIDTH || width > MAX_WIDTH) return Optional.empty();

        for (int h = MIN_HEIGHT; h <= MAX_HEIGHT; h++) {
            if (isMatchingLapisRow(level, bottomLeft, rightDir, width, h)) {
                return Optional.of(new VeilrootPortalShape(rightDir, bottomLeft, width, h - 1));
            }
            if (!isRowClear(level, bottomLeft, rightDir, width, h)) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    private static boolean isMatchingLapisRow(LevelAccessor level, BlockPos bottomLeft, Direction rightDir, int width, int h) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int w = 0; w < width; w++) {
            pos.set(bottomLeft).move(Direction.UP, h).move(rightDir, w);
            if (!level.getBlockState(pos).is(Blocks.LAPIS_BLOCK)) return false;
        }
        return true;
    }

    private static boolean isRowClear(LevelAccessor level, BlockPos bottomLeft, Direction rightDir, int width, int h) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int w = 0; w < width; w++) {
            pos.set(bottomLeft).move(Direction.UP, h).move(rightDir, w);
            if (!level.getBlockState(pos).canBeReplaced()) return false;
        }
        return true;
    }

    public void createPortalBlocks(LevelAccessor level) {
        Direction.Axis axis = this.rightDir.getAxis();
        BlockState normalState = EBlocks.VEILROOT_PORTAL.defaultBlockState()
                .setValue(VeilrootPortalBlock.AXIS, axis)
                .setValue(VeilrootPortalBlock.FADING, false);

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int w = 0; w < this.width; w++) {
            for (int h = 1; h <= this.height; h++) {
                pos.set(this.bottomLeft).move(Direction.UP, h).move(this.rightDir, w);
                level.setBlock(pos, normalState, 18);
            }
        }
    }

    public static void recheckRow(LevelAccessor level, BlockPos anyPortalPos, Direction.Axis axis) {
        Direction rightDir = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        Direction leftDir = rightDir.getOpposite();

        BlockPos.MutableBlockPos scan = anyPortalPos.mutable();
        while (level.getBlockState(scan).is(EBlocks.VEILROOT_PORTAL)) {
            scan.move(Direction.DOWN);
        }
        BlockPos thisBase = scan.immutable();

        scan.set(thisBase);
        while (level.getBlockState(scan.relative(leftDir)).is(Blocks.LAPIS_BLOCK)) {
            scan.move(leftDir);
        }
        BlockPos bottomLeft = scan.immutable();

        scan.set(thisBase);
        while (level.getBlockState(scan.relative(rightDir)).is(Blocks.LAPIS_BLOCK)) {
            scan.move(rightDir);
        }
        BlockPos bottomRight = scan.immutable();

        int width = bottomLeft.distManhattan(bottomRight) + 1;

        int fillHeight = 0;
        if (level.getBlockState(thisBase).is(Blocks.LAPIS_BLOCK) && width >= MIN_WIDTH && width <= MAX_WIDTH) {
            for (int h = MIN_HEIGHT; h <= MAX_HEIGHT; h++) {
                if (isMatchingLapisRow(level, bottomLeft, rightDir, width, h)) {
                    fillHeight = h - 1;
                    break;
                }
                if (!isRowClear(level, bottomLeft, rightDir, width, h)) {
                    break;
                }
            }
        }

        BlockState normalState = EBlocks.VEILROOT_PORTAL.defaultBlockState()
                .setValue(VeilrootPortalBlock.AXIS, axis).setValue(VeilrootPortalBlock.FADING, false);

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int w = 0; w < width; w++) {
            for (int h = 1; ; h++) {
                pos.set(bottomLeft).move(Direction.UP, h).move(rightDir, w);
                if (!level.getBlockState(pos).is(EBlocks.VEILROOT_PORTAL)) break;
                if (fillHeight < 1 || h > fillHeight) {
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 18);
                } else {
                    level.setBlock(pos, normalState, 18);
                }
            }
        }
    }
}