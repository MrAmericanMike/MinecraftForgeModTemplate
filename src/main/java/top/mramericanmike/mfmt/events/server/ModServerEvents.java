package top.mramericanmike.mfmt.events.server;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {
	@SubscribeEvent
	public static void onServerStarting(FMLDedicatedServerSetupEvent event) {
		ModUtils.LOGGER.info("HELLO FROM DEDICATED SERVER SETUP");
	}
}
