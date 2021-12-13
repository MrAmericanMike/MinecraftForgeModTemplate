package mramericanmike.minecraftforgemodtemplate.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab extends CreativeModeTab {

    public static final ModCreativeModeTab TAB = new ModCreativeModeTab(CreativeModeTab.getGroupCountSafe(), "minecraftforgemodtemplate");

    public ModCreativeModeTab(int id, String name) {
        super(id, name);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModItems.EXAMPLE_ITEM.get());
    }
}
