package com.hypernite.plugin.os.levelchat.listener;

import com.hypernite.plugin.os.levelchat.Utils.ColorConfigurator;
import com.hypernite.plugin.os.levelchat.Utils.ConsoleMessageSender;
import com.hypernite.plugin.os.levelchat.main.LevelChat;
import com.hypernite.plugin.os.levelchat.manager.ConfigManager;
import com.hypernite.plugin.os.levelchat.manager.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LevelChangeListener implements Listener {

    @EventHandler
    public void onLevelChanges(PlayerLevelChangeEvent e) {
        boolean isTitleEnable = ConfigManager.isTitleEnable;
        boolean isChatEnable = ConfigManager.isChatMessageEnable;
        boolean isGlobalEnable = ConfigManager.isGlobalMessageEnable;
        boolean isConsoleLog = ConfigManager.isConsoleLog;
        TitleManager titleManager = new TitleManager(e.getPlayer());

        // Define Variable
        Player p = e.getPlayer();
        String oldLevel = String.valueOf(e.getOldLevel());
        String newLevel = String.valueOf(e.getNewLevel());
        String consoleLog = ConfigManager.consoleLog
                .replace("%player%", p.getName())
                .replace("%level%", newLevel)
                .replace("%time%", DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss").format(LocalDateTime.now()));

        // Chat Section
        if(isChatEnable) {
            if(e.getNewLevel() > e.getOldLevel()) {
                p.sendMessage(ColorConfigurator.replace(ConfigManager.prefix + " " + ConfigManager.upgradeChatMessage.replace("%level%", newLevel).replace("%oldLevel%", oldLevel)));
            } else {
                p.sendMessage(ColorConfigurator.replace(ConfigManager.prefix + " " + ConfigManager.downgradeChatMessage.replace("%level%", newLevel).replace("%oldLevel%", oldLevel)));
            }
        }

        // Global Message Section
        if(isGlobalEnable) {
            if(ConfigManager.globalLevels.contains(e.getNewLevel())) {
                for (Player listedPlayer : Bukkit.getServer().getOnlinePlayers()) {
                    listedPlayer.sendMessage(ColorConfigurator.replace(ConfigManager.prefix + " " + ConfigManager.globalMessage
                            .replace("%player%", p.getName())
                            .replace("%level%", newLevel)));
                }
            }
        }

        // Console Log Section
        if(isConsoleLog) ConsoleMessageSender.send(consoleLog, LevelChat.getPlugin(LevelChat.class));

        // Title Section
        if(isTitleEnable) {
            titleManager.setTitle(ColorConfigurator.replace(ConfigManager.title));
            titleManager.setSubtitle(ColorConfigurator.replace(ConfigManager.subtitle).replace("%level%", newLevel));
            titleManager.emitTitleMessage();
        }
    }
}
