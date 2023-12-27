package top.mramericanmike.mfmt.events.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.mramericanmike.mfmt.utils.ModUtils;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModForgeClientEvents {
}
