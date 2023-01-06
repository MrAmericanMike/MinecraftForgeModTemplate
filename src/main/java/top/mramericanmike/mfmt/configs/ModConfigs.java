package top.mramericanmike.mfmt.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigs {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE;

	static {
		BUILDER.push("Minecraft Forge Mod Template");
		TOGGLE = BUILDER.comment("Boolean config as example").define("Toggle", true);
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
