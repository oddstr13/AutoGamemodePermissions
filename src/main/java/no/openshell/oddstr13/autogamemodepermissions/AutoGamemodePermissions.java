package no.openshell.oddstr13.autogamemodepermissions;

import java.util.HashMap;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.Location;
import org.bukkit.util.config.Configuration;

/**
 * AutoGamemodePermissions
 *
 * @author Oddstr13
 */
public class AutoGamemodePermissions extends JavaPlugin {
    private final AutoGamemodePermissionsListener myListener = new AutoGamemodePermissionsListener(this);
//    private final SampleBlockListener blockListener = new SampleBlockListener(this);

    private PluginDescriptionFile pdfFile;
    public Configuration config;


    public void onDisable() {
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled.");
        /* might want to empty the hash maps here? to potentialy free up some RAM */
    }

    public void onEnable() {
        // Register events
        PluginManager pm = getServer().getPluginManager();
        pdfFile = getDescription();
        config = getConfiguration();
        reloadConfig();
        pm.registerEvent(Event.Type.PLAYER_TELEPORT , myListener, Priority.Monitor, this);

        // Register commands
        //getCommand("agp").setExecutor(new AutoGamemodePermissionsCommandhandler(this));

        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");
    }

    public void reloadConfig() {
        config = new Configuration(new File(getDataFolder().getPath() + "/config.yml"));
        config.load();
        config.getBoolean("debug", true);
        config.save();
    }
}
