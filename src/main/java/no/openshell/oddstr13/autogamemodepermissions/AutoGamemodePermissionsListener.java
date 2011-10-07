package no.openshell.oddstr13.autogamemodepermissions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.player.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

/**
 * Handle player events
 * @author Oddstr13
 */
public class AutoGamemodePermissionsListener extends PlayerListener {
    private final AutoGamemodePermissions plugin;

    public AutoGamemodePermissionsListener(AutoGamemodePermissions instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled()) {
        } else {
            Location from = event.getFrom();
            Location to = event.getTo();
            final Player player = event.getPlayer();
            if (from.getWorld().getName() != to.getWorld().getName()) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        if (player.hasPermission("autogamemodepermissions.0")) {
                            player.setGameMode(GameMode.SURVIVAL);
                        } else if (player.hasPermission("autogamemodepermissions.1")) {
                            player.setGameMode(GameMode.CREATIVE);
                        }
                    }
                }, 5);
            }
        }
    }
}
