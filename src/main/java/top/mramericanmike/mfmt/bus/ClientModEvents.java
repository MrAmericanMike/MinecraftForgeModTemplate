package top.mramericanmike.mfmt.bus;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.mramericanmike.mfmt.ModInfo;
import top.mramericanmike.mfmt.ModLogger;

@Mod.EventBusSubscriber(modid = ModInfo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		ModLogger.LOGGER.info("HELLO FROM CLIENT SETUP");
	}
}
