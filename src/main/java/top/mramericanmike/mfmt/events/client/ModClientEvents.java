package top.mramericanmike.mfmt.events.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		ModUtils.LOGGER.info("HELLO FROM CLIENT SETUP");
	}
}
