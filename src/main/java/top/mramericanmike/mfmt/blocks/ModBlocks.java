package top.mramericanmike.mfmt.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.items.ModItems;
import top.mramericanmike.mfmt.utils.ModUtils;

import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModUtils.MOD_ID);

	public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlockAndItem(
			"example_block",
			() -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK)));

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> registryObject = BLOCKS.register(name, block);
		return registryObject;
	}

	private static <T extends Block> RegistryObject<T> registerBlockAndItem(String name, Supplier<T> block) {
		RegistryObject<T> registryObject = BLOCKS.register(name, block);
		ModItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
		return registryObject;
	}
}
