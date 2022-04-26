package com.hypernite.plugin.os.levelchat.main;

import com.hypernite.plugin.os.levelchat.listener.ChatListener;
import com.hypernite.plugin.os.levelchat.utils.ConsoleMessageSender;
import com.hypernite.plugin.os.levelchat.commandExecutor.ReloadCommand;
import com.hypernite.plugin.os.levelchat.listener.LevelChangeListener;
import com.hypernite.plugin.os.levelchat.manager.ConfigManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LevelChat extends JavaPlugin {
    public Plugin plugin = this;

    @Override
    public void onEnable() {
        // Load Config
        ConfigManager.getInstance(this).loadConfig();

        // Plugin Logic
        if(ConfigManager.isPluginEnable) {
            this.getServer().getPluginManager().registerEvents(new LevelChangeListener(), this);
            this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
            this.getCommand("lc-reload").setExecutor(new ReloadCommand());
        } else {
            ConsoleMessageSender.send(ConfigManager.prefix + " &cPlease enable the plugin by changing the config.yml, setting.enable to 'true'", this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
