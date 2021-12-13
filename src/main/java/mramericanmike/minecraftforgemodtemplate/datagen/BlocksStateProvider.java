package mramericanmike.minecraftforgemodtemplate.datagen;

import mramericanmike.minecraftforgemodtemplate.setup.ModBlocks;
import mramericanmike.minecraftforgemodtemplate.setup.ModInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlocksStateProvider extends BlockStateProvider {

	public BlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, ModInfo.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

		addTextureForBlock(ModBlocks.BLACK_STONE);

	}

	private void addTextureForBlock(RegistryObject<Block> block) {
		simpleBlock(block.get());
		simpleBlockItem(block.get(), models().getExistingFile(new ResourceLocation(ModInfo.MOD_ID, "block/" + block.get().getRegistryName().getPath())));
	}
}
