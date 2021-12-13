package mramericanmike.minecraftforgemodtemplate.setup;

import mramericanmike.minecraftforgemodtemplate.items.ExampleItem;
import mramericanmike.minecraftforgemodtemplate.items.GenericModItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModInfo.MOD_ID);
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
			() -> new ExampleItem());
	public static final RegistryObject<Item> SCISSORS = ITEMS.register("scissors",
			() -> new GenericModItem(new Item.Properties().tab(ModCreativeModeTab.TAB)));

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
