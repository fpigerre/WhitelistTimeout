package io.github.psgs.whitelisttimeout;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WhitelistTimeout extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Removing inactive whitelisted players!");
        Set<OfflinePlayer> whiteListedPlayers = Bukkit.getWhitelistedPlayers();
        for (OfflinePlayer player : whiteListedPlayers) {
            if (System.currentTimeMillis() - player.getLastPlayed() > 1209600000) {
                if (player.getPlayer().hasPermission("mapdev.staff")) {
                    return;
                } else {
                    player.setWhitelisted(false);
                }
            }
        }
        System.out.println("Inactive whitelisted players removed!");
        System.out.println("Disabling plugin!");
        getServer().getPluginManager().disablePlugin(this);
    }

    @Override
    public void onDisable() {

    }
}
