package top.mramericanmike.mfmt.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.items.ModItems;
import top.mramericanmike.mfmt.utils.ModUtils;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		addTextureForItem(ModItems.EXAMPLE_ITEM);
	}

	private void addTextureForItem(RegistryObject<Item> item) {
		withExistingParent(
				item.getId().getPath(),
				new ResourceLocation("item/generated"))
				.texture(
						"layer0",
						new ResourceLocation(ModUtils.MOD_ID, "item/" + item.getId().getPath())
				);
	}
}
