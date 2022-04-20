package com.hypernite.plugin.os.levelchat.commandExecutor;

import com.hypernite.plugin.os.levelchat.Utils.ColorConfigurator;
import com.hypernite.plugin.os.levelchat.Utils.ConsoleMessageSender;
import com.hypernite.plugin.os.levelchat.main.LevelChat;
import com.hypernite.plugin.os.levelchat.manager.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(!sender.isOp()) return false;

            ConfigManager.getInstance(LevelChat.getPlugin(LevelChat.class)).loadConfig();
            sender.sendMessage(ColorConfigurator.replace(ConfigManager.prefix + " &aConfiguration reloaded successfully."));
        } else {
            ConfigManager.getInstance(LevelChat.getPlugin(LevelChat.class)).loadConfig();
            ConsoleMessageSender.send(ColorConfigurator.replace(" &aConfiguration reloaded successfully."), LevelChat.getPlugin(LevelChat.class));
        }
        return true;
    }
}
