package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.LagVerify;
import team.martin.hfix.hFix;

public class LagVerifyConfig {
    public void enable(){
        PluginManager pm = Bukkit.getServer().getPluginManager();
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableLagVerify")){
            if (!hFix.getPluginMainClass().getServer().getVersion().contains("Spigot")){
                try {
                    pm.registerEvents(new LagVerify(), (hFix.getPluginMainClass()));
                    System.out.println("[+] Módulo LagVerify.");
                } catch (Exception e) {
                    System.out.println("*** Módulo de LagVerify não compatível.");
                }
            } else {
                System.out.println("*** Módulo de LagVerify não é compatível com Spigot, utilize Paper. https://papermc.io/downloads");
            }
        }
    }
}
