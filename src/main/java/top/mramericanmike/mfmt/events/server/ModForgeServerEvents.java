package top.mramericanmike.mfmt.events.server;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModForgeServerEvents {
	@SubscribeEvent
	public static void onServerStarting(ServerStartingEvent event) {
		ModUtils.LOGGER.info("HELLO FROM SERVER STARTING");
	}
}
