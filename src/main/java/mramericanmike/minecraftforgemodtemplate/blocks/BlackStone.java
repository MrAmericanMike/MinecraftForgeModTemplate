package mramericanmike.minecraftforgemodtemplate.blocks;

import mramericanmike.minecraftforgemodtemplate.setup.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class BlackStone extends GenericModBlock {
	public BlackStone() {
		super(Properties.of(Material.STONE).sound(SoundType.STONE));
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
		if (!level.isClientSide()) {
			if (player.getItemInHand(hand).getItem() == ModItems.SCISSORS.get()) {
				level.destroyBlock(blockPos, true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.use(blockState, level, blockPos, player, hand, blockHitResult);
	}
}
