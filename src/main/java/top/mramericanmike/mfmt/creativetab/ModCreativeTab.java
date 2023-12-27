package top.mramericanmike.mfmt.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.configs.ModConfigs;
import top.mramericanmike.mfmt.items.ModItems;
import top.mramericanmike.mfmt.utils.ModUtils;

public class ModCreativeTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModUtils.MOD_ID);

	public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.withTabsBefore(CreativeModeTabs.COMBAT)
			.title(Component.translatable("item_group.mfmt.tab"))
			.icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
			.displayItems((parameters, output) -> {
				output.accept(ModItems.EXAMPLE_ITEM.get());
				output.accept(ModBlocks.EXAMPLE_BLOCK.get());
			}).build());

}
