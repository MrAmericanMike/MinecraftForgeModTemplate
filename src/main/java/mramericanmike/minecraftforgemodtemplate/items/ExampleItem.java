package mramericanmike.minecraftforgemodtemplate.items;

import mramericanmike.minecraftforgemodtemplate.setup.ModCreativeModeTab;
import mramericanmike.minecraftforgemodtemplate.sounds.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExampleItem extends Item {
	public ExampleItem() {
		super(new Properties()
				.stacksTo(1)
				.tab(ModCreativeModeTab.TAB)
		);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		context.getLevel().playSound((Player) null, context.getClickedPos(), ModSounds.FROG.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
		//context.getLevel().playLocalSound((double) context.getClickedPos().getX(), (double) context.getClickedPos().getY(), (double) context.getClickedPos().getZ(), ModSounds.FROG.get(), SoundSource.BLOCKS, 1.0f, 1.0f, true);
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemStack, level, list, flag);
		list.add(new TranslatableComponent("hint.minecraftforgemodtemplate.example_item"));
	}
}
