package top.mramericanmike.mfmt.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.blocks.ModBlocks;
import top.mramericanmike.mfmt.utils.ModUtils;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
		super(output, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		addTextureForBlock(ModBlocks.EXAMPLE_BLOCK);
	}

	private void addTextureForBlock(RegistryObject<Block> block) {
		simpleBlock(block.get());
		simpleBlockItem(block.get(), models().getExistingFile(new ResourceLocation(ModUtils.MOD_ID, "block/" + block.getId().getPath())));
	}
}
