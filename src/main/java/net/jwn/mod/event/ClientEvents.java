package net.jwn.mod.event;

import net.jwn.mod.Main;
import net.jwn.mod.client.LoadingHudOverlay;
import net.jwn.mod.client.ToastHudOverlay;
import net.jwn.mod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            Player player = Minecraft.getInstance().player;
            if (KeyBinding.CUSTOM_1_KEY.consumeClick()) {
                if (player != null) {
//                    player.sendSystemMessage(Component.literal("Custom 1 Key: Hud Switch"));
                    player.getPersistentData().putBoolean(Main.MOD_ID + "_hud", true);
                    player.getPersistentData().putInt(Main.MOD_ID + "_x", 0);
                }
            } else if (KeyBinding.CUSTOM_2_KEY.consumeClick()) {
                if (player != null) {
//                    player.sendSystemMessage(Component.literal("Custom 2 Key: Accept Switch"));
                    if (player.getPersistentData().getBoolean(Main.MOD_ID + "_hud")) {
                        if (player.getPersistentData().getInt(Main.MOD_ID + "_x") < 160) {
                            player.getPersistentData().putInt(Main.MOD_ID + "_x",
                                    ToastHudOverlay.TIMER + 160 - player.getPersistentData().getInt(Main.MOD_ID + "_x"));
                        } else {
                            player.getPersistentData().putInt(Main.MOD_ID + "_x",
                                    Math.max(ToastHudOverlay.TIMER, player.getPersistentData().getInt(Main.MOD_ID + "_x")));
                        }
                    }
                }
            } else if (KeyBinding.CUSTOM_3_KEY.consumeClick()) {
                if (player != null) {
//                    player.sendSystemMessage(Component.literal("Custom 3 Key: Loading Switch"));
                    player.getPersistentData().putBoolean(Main.MOD_ID + "_isLoading",
                            !player.getPersistentData().getBoolean(Main.MOD_ID + "_isLoading"));
                    player.getPersistentData().putInt(Main.MOD_ID + "_loading", 0);
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.CUSTOM_1_KEY);
            event.register(KeyBinding.CUSTOM_2_KEY);
            event.register(KeyBinding.CUSTOM_3_KEY);
        }

        @SubscribeEvent
        public static void onRegisterGuiOverlaysEvent(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("toast_hud", ToastHudOverlay.TOAST_HUD);
            event.registerAboveAll("loading_hud", LoadingHudOverlay.LOADING_HUD);
        }
    }
}
