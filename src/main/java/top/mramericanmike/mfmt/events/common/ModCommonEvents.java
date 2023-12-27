package top.mramericanmike.mfmt.events.common;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
	@SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent event) {
		ModUtils.LOGGER.info("HELLO FROM COMMON SETUP");
	}
}
