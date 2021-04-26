package team.martin.hfix;

import org.bukkit.plugin.java.JavaPlugin;
import team.martin.hfix.util.ConfigUtils;

public class hFix extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigUtils cfg = new ConfigUtils();
        cfg.getEventos();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }

    public static hFix getPluginMainClass(){
        return getPlugin(hFix.class);
    }


}
