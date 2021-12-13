package mramericanmike.minecraftforgemodtemplate.datagen;

import mramericanmike.minecraftforgemodtemplate.setup.ModInfo;
import mramericanmike.minecraftforgemodtemplate.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemsModelProvider extends ItemModelProvider {
	public ItemsModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, ModInfo.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		addTextureForItem(ModItems.EXAMPLE_ITEM);
		addTextureForItem(ModItems.SCISSORS);
	}

	private void addTextureForItem(RegistryObject<Item> item) {
		singleTexture(item.get().getRegistryName().getPath(),
				new ResourceLocation("item/handheld"),
				"layer0",
				new ResourceLocation(ModInfo.MOD_ID, "item/" + item.get().getRegistryName().getPath()));
	}
}
