package dev.nanosync.hfix;

/**
 *
 * O plugin foi feito com o intuíto de arrumar alguns bugs e adicionar funcionalidades para os servidores,
 * Caro desenvolvedor, permito apenas a criação de classes no projeto para você implementar novos recursos.
 * E sempre documente alterações.
 *
 * @author Martinfer22
 */


import dev.nanosync.hfix.features.mob.LimitMobsFeature;
import dev.nanosync.hfix.api.MetricsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class hFix extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new MetricsAPI(this, 11241);

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new LimitMobsFeature(), this);

        System.out.println(ChatColor.GREEN +
                "  _       _____   _        " + System.lineSeparator() + ChatColor.GREEN +
                " | |__   |  ___| (_) __  __" + System.lineSeparator() + ChatColor.GREEN +
                " | '_ \\  | |_    | | \\ \\/ /" + System.lineSeparator() + ChatColor.GREEN +
                " | | | | |  _|   | |  >  < " + System.lineSeparator() + ChatColor.GREEN +
                " |_| |_| |_|     |_| /_/\\_\\" + System.lineSeparator() + ChatColor.GREEN +
                "                           ");


    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "hFix está se desligando corretamente");
    }

    public static hFix getPluginMainClass(){
        return getPlugin(hFix.class);
    }
}
