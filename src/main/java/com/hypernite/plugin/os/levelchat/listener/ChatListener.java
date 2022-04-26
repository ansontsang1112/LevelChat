package com.hypernite.plugin.os.levelchat.listener;

import com.hypernite.plugin.os.levelchat.manager.ConfigManager;
import com.hypernite.plugin.os.levelchat.utils.ColorConfigurator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChatFormatter(AsyncPlayerChatEvent e) {
        if(ConfigManager.isFormatEnable) {
            Player p = e.getPlayer();
            e.setFormat(ColorConfigurator.replace(ConfigManager.chatFormat.replace("%level%", String.valueOf(p.getLevel()))) + e.getFormat());
        }
    }
}
