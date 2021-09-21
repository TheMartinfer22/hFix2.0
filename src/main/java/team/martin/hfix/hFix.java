package team.martin.hfix;

/**
 *
 * O plugin foi feito com o intuíto de arrumar alguns bugs e adicionar funcionalidades para os servidores,
 * Caro desenvolvedor, permito apenas a criação de classes no projeto para você implementar novos recursos.
 * E sempre documente alterações.
 *
 * @author Martinfer22
 */


import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import team.martin.hfix.util.ConfigUtils;
import team.martin.hfix.util.Metrics;

public class hFix extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigUtils cfg = new ConfigUtils();

        System.out.println(ChatColor.GREEN +
                "  _       _____   _        " + System.lineSeparator() + ChatColor.GREEN +
                " | |__   |  ___| (_) __  __" + System.lineSeparator() + ChatColor.GREEN +
                " | '_ \\  | |_    | | \\ \\/ /" + System.lineSeparator() + ChatColor.GREEN +
                " | | | | |  _|   | |  >  < " + System.lineSeparator() + ChatColor.GREEN +
                " |_| |_| |_|     |_| /_/\\_\\" + System.lineSeparator() + ChatColor.GREEN +
                "                           ");
        System.out.println();

        cfg.getEventos();
        int pluginId = 11241;
        new Metrics(this, pluginId);
    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "hFix está se desligando corretamente");
    }

    public static hFix getPluginMainClass(){
        return getPlugin(hFix.class);
    }
}
