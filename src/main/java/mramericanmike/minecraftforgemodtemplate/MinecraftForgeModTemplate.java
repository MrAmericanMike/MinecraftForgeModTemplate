package mramericanmike.minecraftforgemodtemplate;

import mramericanmike.minecraftforgemodtemplate.setup.ModInfo;
import mramericanmike.minecraftforgemodtemplate.setup.ModItems;
import mramericanmike.minecraftforgemodtemplate.sounds.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModInfo.MOD_ID)
public class MinecraftForgeModTemplate {
    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftForgeModTemplate() {
        ModItems.init();
        ModSounds.register();
        MinecraftForge.EVENT_BUS.register(this);
    }

}
