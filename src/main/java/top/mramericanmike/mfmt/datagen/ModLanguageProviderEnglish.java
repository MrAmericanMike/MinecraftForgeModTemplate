package top.mramericanmike.mfmt.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.items.ModItems;

public class ModLanguageProviderEnglish extends LanguageProvider {
	public ModLanguageProviderEnglish(PackOutput output, String modid) {
		super(output, modid, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("item_group.mfmt.tab", "Minecraft Forge Mod Template");
		
		add(ModItems.EXAMPLE_ITEM.get(), "Example Item");
		add(ModBlocks.EXAMPLE_BLOCK.get(), "Example Block");
	}
}
