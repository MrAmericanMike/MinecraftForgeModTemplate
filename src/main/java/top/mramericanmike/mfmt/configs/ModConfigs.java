package top.mramericanmike.mfmt.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import top.mramericanmike.mfmt.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

	private static final ForgeConfigSpec.BooleanValue SOME_BOOLEAN = BUILDER
			.comment("Some boolean just for testing")
			.define("someBoolean", true);

	public static final ForgeConfigSpec SPEC = BUILDER.build();

	public static boolean someBoolean;

	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		someBoolean = SOME_BOOLEAN.get();
	}
}
