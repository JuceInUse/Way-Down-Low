package net.juceinuse.way_down_low.mixin;

import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.block.TungstenFireBlock;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public abstract class AbstractFireBlockMixin {
	@Inject(at = @At("HEAD"), method = "getState", cancellable = true)
	private static void injected(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
		BlockState blockState = world.getBlockState(pos.down());
		if (TungstenFireBlock.isTungstenBase(blockState)) {
			cir.setReturnValue(ModBlocks.TUNGSTEN_FIRE.getDefaultState());
		}
	}
}