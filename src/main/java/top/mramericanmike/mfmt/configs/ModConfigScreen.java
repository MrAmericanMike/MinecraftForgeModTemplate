package top.mramericanmike.mfmt.configs;

import com.mojang.blaze3d.platform.Monitor;
import com.mojang.blaze3d.platform.VideoMode;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public class ModConfigScreen extends Screen {
	private final Screen prev;
	private Checkbox toggleCheckbox;
	private EditBox testEditBox;
	private OptionsList list;

	public ModConfigScreen(Screen prevScreen) {
		super(Component.translatable("mfmt.configGui.title"));
		this.prev = prevScreen;
	}

	@Override
	public void init() {

		this.list = new OptionsList(this.minecraft, this.width, this.height, 32, this.height - 32, 25);

		int i = -1;
		Window window = this.minecraft.getWindow();
		Monitor monitor = window.findBestMonitor();
		int j;
		if (monitor == null) {
			j = -1;
		} else {
			Optional<VideoMode> optional = window.getPreferredFullscreenVideoMode();
			j = optional.map(monitor::getVideoModeIndex).orElse(-1);
		}

		OptionInstance<Integer> optioninstance = new OptionInstance<>("options.fullscreen.resolution", OptionInstance.noTooltip(), (p_232806_, p_232807_) -> {
			if (monitor == null) {
				return Component.translatable("options.fullscreen.unavailable");
			} else {
				return p_232807_ == -1 ? Options.genericValueLabel(p_232806_, Component.translatable("options.fullscreen.current")) : Options.genericValueLabel(p_232806_, Component.literal(monitor.getMode(p_232807_).toString()));
			}
		}, new OptionInstance.IntRange(-1, monitor != null ? monitor.getModeCount() - 1 : -1), j, (p_232803_) -> {
			if (monitor != null) {
				window.setPreferredFullscreenVideoMode(p_232803_ == -1 ? Optional.empty() : Optional.of(monitor.getMode(p_232803_)));
			}
		});
		this.list.addBig(optioninstance);

//		this.addWidget(this.list);
		addRenderableWidget(this.list);
		//"Done Button"
		addRenderableWidget(
				Button.builder(
								CommonComponents.GUI_DONE,
								(button) -> minecraft.setScreen(prev))
						.bounds(width / 2 - 75, height - 28, 150, 20).build()
		);

		addRenderableWidget(toggleCheckbox = new Checkbox(
				5,
				20,
				24,
				20,
				Component.translatable("mfmt.configGui.toggleCheckbox"),
				ModConfigs.TOGGLE.get()));


		addRenderableWidget(testEditBox = new EditBox(
				font,
				5,
				44,
				60,
				18,
				Component.literal("XXX")));

		testEditBox.setValue("XXX");
		tick();
	}

	@Override
	public void onClose() {
		// Go back to previous screen
		minecraft.setScreen(prev);
	}

	@Override
	public void removed() {
		// Here the settings should be saved
	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
		// Draw Background
		renderBackground(poseStack);
		// Draw Title
		drawCenteredString(poseStack, font, this.title, width / 2, 5, -1);
		super.render(poseStack, mouseX, mouseY, delta);
	}
}
