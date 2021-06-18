package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.NoNetherRoofEvent;
import team.martin.hfix.hFix;

public class NoNetherRoofConfig {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableAntiCeilingNether")){
            try {
                pm.registerEvents(new NoNetherRoofEvent(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiTetoNether.");
            } catch (Exception e) {
                System.out.println("*** Módulo de AntiTetoNether não compatível.");
            }
        }
    }

    public String getFraseAntiTetoDoNether(){
        return hFix.getPluginMainClass().getConfig().getString("PhraseAntiCeilingDoNetherTOP");
    }

    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("PhraseAntiCeilingDoNetherDOWN");
    }
}
