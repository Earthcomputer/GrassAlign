package net.earthcomputer.grassalign.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "getOffsetPos", at = @At("HEAD"), cancellable = true)
    private void getGrassOffsetPos(BlockState state, BlockView view, BlockPos pos, CallbackInfoReturnable<Vec3d> ci) {
        if ((Object) this == Blocks.GRASS) {
            long var17 = (long)(pos.getX() * 3129871) ^ (long)pos.getZ() * 116129781L ^ (long)pos.getY();
            var17 = var17 * var17 * 42317861L + var17 * 11L;
            double dx = ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
            double dy = ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
            double dz = ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
            ci.setReturnValue(new Vec3d(dx, dy, dz));
        }
    }
}
