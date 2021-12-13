package mramericanmike.minecraftforgemodtemplate.items;

import mramericanmike.minecraftforgemodtemplate.setup.ModCreativeModeTab;
import mramericanmike.minecraftforgemodtemplate.sounds.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class ExampleItem extends Item {
	public ExampleItem() {
		super(new Properties()
				.stacksTo(1)
				.tab(ModCreativeModeTab.TAB)
		);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		//context.getLevel().playSound(context.getPlayer(), context.getClickedPos(), ModSounds.FROG.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
		context.getLevel().playLocalSound((double) context.getClickedPos().getX(), (double) context.getClickedPos().getY(), (double) context.getClickedPos().getZ(), ModSounds.FROG.get(), SoundSource.BLOCKS, 1.0f, 1.0f, true);
		return InteractionResult.SUCCESS;
	}

}
