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
import team.martin.hfix.events.LagVerify;
import team.martin.hfix.util.LogUtils;
import team.martin.hfix.util.Metrics;

public class hFix extends JavaPlugin {

    LogUtils log = new LogUtils();

    @Override
    public void onEnable() {
        try {
            log.getInit();
            saveDefaultConfig();
            int pluginId = 11241;
            new Metrics(this, pluginId);

        } catch (Exception e){
            System.out.println(ChatColor.RED + "Something went wrong at startup.");
            System.out.println(ChatColor.RED + "Report the sentences below in GitHub https://github.com/TheMartinfer22/hFix");
            e.getStackTrace();
        }
    }
    @Override
    public void onDisable() {
        log.getExit();
    }
    public static hFix getPluginMainClass(){
        return getPlugin(hFix.class);
    }
}
