package top.mramericanmike.mfmt.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.mramericanmike.mfmt.utils.ModUtils;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ModUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> providerCompletableFuture = event.getLookupProvider();

		generator.addProvider(event.includeClient(), new ModLanguageProviderEnglish(packOutput, ModUtils.MOD_ID));

		generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
		generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

		generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, ModUtils.MOD_ID, existingFileHelper));
		generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, ModUtils.MOD_ID, existingFileHelper));

		ModBlockTagsProvider modBlockTagsProvider = generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, providerCompletableFuture, ModUtils.MOD_ID, existingFileHelper));
		generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, providerCompletableFuture, modBlockTagsProvider.contentsGetter(), ModUtils.MOD_ID, existingFileHelper));
	}


}
