package mramericanmike.minecraftforgemodtemplate.sounds;

import mramericanmike.minecraftforgemodtemplate.setup.ModInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModInfo.MOD_ID);

    public static final RegistryObject<SoundEvent> FROG = registerSound("frog");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(ModInfo.MOD_ID, name)));
    }

    public static void register() {

        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
}
