package mramericanmike.minecraftforgemodtemplate.setup;

import mramericanmike.minecraftforgemodtemplate.blocks.BlackStone;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModInfo.MOD_ID);

	public static final RegistryObject<Block> BLACK_STONE = BLOCKS.register("black_stone",
			() -> new BlackStone());

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

}
