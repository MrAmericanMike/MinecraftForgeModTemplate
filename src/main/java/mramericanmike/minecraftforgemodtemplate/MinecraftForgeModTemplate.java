package mramericanmike.minecraftforgemodtemplate;

import mramericanmike.minecraftforgemodtemplate.setup.ModBlocks;
import mramericanmike.minecraftforgemodtemplate.setup.ModInfo;
import mramericanmike.minecraftforgemodtemplate.setup.ModItems;
import mramericanmike.minecraftforgemodtemplate.sounds.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ModInfo.MOD_ID)
public class MinecraftForgeModTemplate {
	
	public MinecraftForgeModTemplate() {
		ModBlocks.init();
		ModItems.init();
		ModSounds.register();
		MinecraftForge.EVENT_BUS.register(this);
	}

}
