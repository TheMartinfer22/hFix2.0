package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.bloqueios.AntNetherY;
import team.martin.hfix.hFix;

public class ConfigUtils{
    PluginManager pm = Bukkit.getServer().getPluginManager();

    public String getFraseAntiNetherYTOP(){
        return hFix.getPluginMainClass().getConfig().getString("fraseAntiNetherYTOP");
    }
    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("fraseAntiNetherYDOWN");
    }

    public void getEventos(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("ativarAntNetherY")){
            try {
                pm.registerEvents((Listener) new AntNetherY(), (hFix.getPluginMainClass()));
                System.out.println(ChatColor.GREEN + "[+] Módulo AntNetherY.");
            } catch (Exception e) {
                System.out.println(ChatColor.RED + "*** Módulo de AntNetherY não compatível, desativando.");
            }
        }
    }
}
