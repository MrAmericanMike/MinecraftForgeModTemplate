package top.mramericanmike.mfmt.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.ModInfo;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModInfo.MOD_ID);

	public static final RegistryObject<Item> MULTITOOL_ITEM = ITEMS.register("multitool_item", () -> new MultitoolItem(MultitoolMaterial.IRON, 1, -2.8F, new Item.Properties()));

	public static void registerItems(IEventBus modEventBus) {
		ITEMS.register(modEventBus);
	}
}
