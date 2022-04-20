package com.hypernite.plugin.os.levelchat.Utils;

import com.hypernite.plugin.os.levelchat.manager.ConfigManager;
import org.bukkit.plugin.Plugin;

public class ConsoleMessageSender {
    public static void send(String str, Plugin plugin) {
        plugin.getLogger().info(str);
    }
}
