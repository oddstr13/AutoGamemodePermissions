package no.openshell.oddstr13.autogamemodepermissions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.player.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Handle vehicle events
 * @author Oddstr13
 */
public class AutoGamemodePermissionsListener extends PlayerListener {
    private final AutoGamemodePermissions plugin;

    public AutoGamemodePermissionsListener(AutoGamemodePermissions instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerTeleport(PlayerTeleportEvent event) {

    }
}
