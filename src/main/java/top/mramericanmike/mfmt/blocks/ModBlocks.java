package top.mramericanmike.mfmt.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.mramericanmike.mfmt.ModInfo;
import top.mramericanmike.mfmt.items.ModItems;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModInfo.MOD_ID);

	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
	public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ModItems.ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

	public static void registerBlocks(IEventBus modEventBus) {
		BLOCKS.register(modEventBus);
	}
}
