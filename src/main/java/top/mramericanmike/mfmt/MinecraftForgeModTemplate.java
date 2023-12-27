package top.mramericanmike.mfmt;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.configs.ModConfigs;
import top.mramericanmike.mfmt.creativetab.ModCreativeTab;
import top.mramericanmike.mfmt.items.ModItems;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod(ModUtils.MOD_ID)
public class MinecraftForgeModTemplate {

	public MinecraftForgeModTemplate() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModConfigs.register();
		ModItems.ITEMS.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);
		ModCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

		// Register ourselves for server and other game events we are interested in
		// MinecraftForge.EVENT_BUS.register(this);
	}

}
