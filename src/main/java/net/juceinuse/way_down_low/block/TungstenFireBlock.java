package net.juceinuse.way_down_low.block;

import com.mojang.serialization.MapCodec;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class TungstenFireBlock extends AbstractFireBlock {
    public static final MapCodec<TungstenFireBlock> CODEC = createCodec(TungstenFireBlock::new);

    @Override
    protected MapCodec<? extends AbstractFireBlock> getCodec() {
        return CODEC;
    }

    public TungstenFireBlock(Settings settings) {
        super(settings, 3.0F);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isTungstenBase(world.getBlockState(pos.down()));
    }

    public static boolean isTungstenBase(BlockState state) {
        return state.isIn(ModTags.Blocks.TUNGSTEN_FIRE_BASE_BLOCKS);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}