package com.hypernite.plugin.os.levelchat.manager;

import org.bukkit.entity.Player;

public class TitleManager {
    private String title;
    private String subtitle;
    private Player player;

    public TitleManager(Player player) {
        this.player = player;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void emitTitleMessage() {
        if(subtitle.isEmpty()) {
            player.sendTitle(title, "", 10, ConfigManager.titleDuration*20, 70);
        } else {
            player.sendTitle(title, subtitle, 10, ConfigManager.titleDuration*20, 70);
        }
    }
}
