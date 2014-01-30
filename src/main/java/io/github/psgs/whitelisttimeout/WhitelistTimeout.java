package io.github.psgs.whitelisttimeout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class WhitelistTimeout extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("whitelist")) {
            if (args[0].equalsIgnoreCase("timeout")) {
                Set<OfflinePlayer> whiteListedPlayers = Bukkit.getWhitelistedPlayers();
                for (OfflinePlayer player : whiteListedPlayers) {
                    if (System.currentTimeMillis() - player.getLastPlayed() > 1209600000) {
                        if (!player.getPlayer().hasPermission("mapdev.staff")) {
                            player.setWhitelisted(false);
                        }
                    }
                }
                sender.sendMessage(ChatColor.GREEN + "Inactive whitelisted players removed!");
            }
        }
        return false;
    }
}
