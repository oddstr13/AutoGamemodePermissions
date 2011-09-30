package no.openshell.oddstr13.autogamemodepermissions;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Handler for the /pos sample command.
 * @author SpaceManiac
 */
public class AutoGamemodePermissionsCommandhandler implements CommandExecutor {
    private final AutoGamemodePermissions plugin;

    public AutoGamemodePermissionsCommandhandler(AutoGamemodePermissions plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (plugin.config.getBoolean("debug", false)) {
            System.out.println("[DEBUG]: command agp executed");
        }
        boolean isconsolle = false;
        boolean isop = false;
        boolean isplayer = false;
        boolean debug = plugin.config.getBoolean("debug", false);
        Player player;

        if (sender instanceof Player) {
            player = (Player)sender;
            isop = player.isOp();
            isplayer = true;
        } else {
            isconsolle = true;
        }

        if (split.length == 1) {
            if (isconsolle || isop) {
                if (split[0].equalsIgnoreCase("reload")) {
                    if (debug) {
                        System.out.println("[DEBUG]: reloading config");
                    }
                    plugin.reloadConfig();
                    if (debug) {
                        System.out.println("[DEBUG]: config reloaded");
                    }
                    if (isplayer) {
                        player = (Player)sender;
                        player.sendMessage("AutoGamemodePermissions config reloaded.");
                    }
                    return true;
                }
            }
        }

        if (!(isplayer)) {
            return false;
        }
        player = (Player)sender;
        player.sendMessage("/agp");
        return true;
    }
}
