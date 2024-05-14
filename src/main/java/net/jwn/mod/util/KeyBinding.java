package net.jwn.mod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_CUSTOM = "key.category.mod_players.custom";
    public static final String KEY_CUSTOM_1 = "key.mod_standby_screen.custom_1";
    public static final String KEY_CUSTOM_2 = "key.mod_standby_screen.custom_2";
    public static final String KEY_CUSTOM_3 = "key.mod_standby_screen.custom_3";


    public static final KeyMapping CUSTOM_1_KEY = new KeyMapping(KEY_CUSTOM_1, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_CUSTOM);
    public static final KeyMapping CUSTOM_2_KEY = new KeyMapping(KEY_CUSTOM_2, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_J, KEY_CATEGORY_CUSTOM);
    public static final KeyMapping CUSTOM_3_KEY = new KeyMapping(KEY_CUSTOM_3, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, KEY_CATEGORY_CUSTOM);
}
