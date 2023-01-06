package top.mramericanmike.mfmt.items;

import com.google.common.collect.ImmutableMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Map;
import java.util.Optional;

public class MultitoolItem extends DiggerItem {

	protected final float speed;

	private final TagKey<Block> blocksPickaxe = BlockTags.MINEABLE_WITH_PICKAXE;
	private final TagKey<Block> blocksAxe = BlockTags.MINEABLE_WITH_AXE;
	private final TagKey<Block> blocksShovel = BlockTags.MINEABLE_WITH_SHOVEL;
	private final TagKey<Block> blocksHoe = BlockTags.MINEABLE_WITH_HOE;

	protected static final Map<Block, Block> STRIPPABLES = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD).put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK).build();

	public MultitoolItem(Tier tier, float speed, float damage, Item.Properties properties) {
		super(speed, damage, tier, BlockTags.NEEDS_STONE_TOOL, properties);
		this.speed = tier.getSpeed();
	}

	@Override
	public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
		if (blockState.is(this.blocksPickaxe) ||
				blockState.is(this.blocksAxe) ||
				blockState.is(this.blocksShovel) ||
				blockState.is(this.blocksHoe)) {
			return this.speed;
		} else {
			return 1.0F;
		}
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack itemStack, BlockState blockState) {
		return net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(getTier(), blockState);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return
				ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) ||
						ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) ||
						ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) ||
						ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction);
	}

	@Override
	public InteractionResult useOn(UseOnContext p_40529_) {
		Level level = p_40529_.getLevel();
		BlockPos blockpos = p_40529_.getClickedPos();
		Player player = p_40529_.getPlayer();
		BlockState blockstate = level.getBlockState(blockpos);
		Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(p_40529_, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
		Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(p_40529_, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
		Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(p_40529_, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
		ItemStack itemstack = p_40529_.getItemInHand();
		Optional<BlockState> optional3 = Optional.empty();
		if (optional.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			optional3 = optional;
		} else if (optional1.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3005, blockpos, 0);
			optional3 = optional1;
		} else if (optional2.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3004, blockpos, 0);
			optional3 = optional2;
		}

		if (optional3.isPresent()) {
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
			}

			level.setBlock(blockpos, optional3.get(), 11);
			level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
			if (player != null) {
				itemstack.hurtAndBreak(1, player, (p_150686_) -> {
					p_150686_.broadcastBreakEvent(p_40529_.getHand());
				});
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

	@org.jetbrains.annotations.Nullable
	public static BlockState getAxeStrippingState(BlockState originalState) {
		Block block = STRIPPABLES.get(originalState.getBlock());
		return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)) : null;
	}

	private Optional<BlockState> getStripped(BlockState p_150691_) {
		return Optional.ofNullable(STRIPPABLES.get(p_150691_.getBlock())).map((p_150689_) -> {
			return p_150689_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, p_150691_.getValue(RotatedPillarBlock.AXIS));
		});
	}

}
