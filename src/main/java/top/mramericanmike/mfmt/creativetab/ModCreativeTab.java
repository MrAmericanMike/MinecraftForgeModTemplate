package top.mramericanmike.mfmt.creativetab;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import top.mramericanmike.mfmt.ModInfo;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.items.ModItems;

public class ModCreativeTab {
	public static void createCreativeModeTab(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(ModInfo.MOD_ID, "creative_tab"),
				(builder) -> builder.title(Component.translatable("item_group." + ModInfo.MOD_ID + ".creative_tab"))
						.icon(() -> new ItemStack(ModItems.MULTITOOL_ITEM.get()))
						.displayItems((featureFlagSet, output, bool) -> {
							output.accept(ModItems.MULTITOOL_ITEM.get());
							output.accept(ModBlocks.EXAMPLE_BLOCK_ITEM.get());
						})
		);
	}
}
