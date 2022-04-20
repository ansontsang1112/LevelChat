package com.hypernite.plugin.os.levelchat.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

public class ConfigManager {
    public static boolean isPluginEnable, isTitleEnable, isChatMessageEnable, isGlobalMessageEnable, isConsoleLog;
    public static String prefix, title, subtitle, upgradeChatMessage, downgradeChatMessage, globalMessage, consoleLog;
    public static List<?> globalLevels;
    public static int titleDuration;

    private FileConfiguration fileConfiguration;
    private File configFile;
    private static ConfigManager configManager;

    private ConfigManager(Plugin plugin) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists()) {
            plugin.saveResource("config.yml", true);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public static ConfigManager getInstance(Plugin plugin) {
        if(configManager == null) {
            configManager = new ConfigManager(plugin);
        }

        return configManager;
    }

    public void loadConfig() {
        isPluginEnable = fileConfiguration.getBoolean("settings.enable");
        isTitleEnable = fileConfiguration.getBoolean("titles.enable");
        isChatMessageEnable = fileConfiguration.getBoolean("message.chat.enable");
        isGlobalMessageEnable = fileConfiguration.getBoolean("message.global.enable");
        isConsoleLog = fileConfiguration.getBoolean("settings.enable_console_log");

        prefix = fileConfiguration.getString("settings.prefix");
        title = fileConfiguration.getString("titles.title");
        subtitle = fileConfiguration.getString("titles.subtitle");
        upgradeChatMessage = fileConfiguration.getString("message.chat.upgrade_msg");
        downgradeChatMessage = fileConfiguration.getString("message.chat.downgrade_msg");
        globalMessage = fileConfiguration.getString("message.global.msg");
        globalLevels = fileConfiguration.getList("message.global.global_announcement_requirement");
        consoleLog = fileConfiguration.getString("settings.console_message");

        titleDuration = fileConfiguration.getInt("titles.duration");
    }
}
