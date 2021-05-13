package team.martin.hfix;

/**
 *
 * O plugin foi feito com o intuíto de arrumar alguns bugs e adicionar funcionalidades para os servidores,
 * Caro desenvolvedor, permito apenas a criação de classes no projeto para você implementar novos recursos.
 * E sempre documente alterações.
 *
 * @version 1.4
 * @author Martinfer22
 */


import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import team.martin.hfix.util.LogUtils;
import team.martin.hfix.util.Metrics;

public class hFix extends JavaPlugin {

    LogUtils log = new LogUtils();

    @Override
    public void onEnable() {
        try {
            log.getInit(); // Inicializador.
            saveDefaultConfig(); // Salvando configuração padrão.

            int pluginId = 11241; // Metrics bStats
            new Metrics(this, pluginId); // Metrics bStats

        } catch (Exception e){
            System.out.println(ChatColor.RED + "Algo deu errado na inicialização.");
            System.out.println(ChatColor.RED + "Reporte as frases abaixo na github https://github.com/TheMartinfer22/hFix");
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
