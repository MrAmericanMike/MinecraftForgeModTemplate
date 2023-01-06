package top.mramericanmike.mfmt;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.configs.ModConfigs;
import top.mramericanmike.mfmt.creativetab.ModCreativeTab;
import top.mramericanmike.mfmt.items.ModItems;

@Mod(ModInfo.MOD_ID)
public class MinecraftForgeModTemplate {

	public MinecraftForgeModTemplate() {
		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, "MinecraftForgeModTemplate-client.toml");

		// Config Button in game (WIP)
		//ModConfigs.registerModsPage();

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.registerBlocks(modEventBus);
		ModItems.registerItems(modEventBus);

		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(ModCreativeTab::createCreativeModeTab);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		ModLogger.LOGGER.info("HELLO FROM COMMON SETUP");
	}
}
