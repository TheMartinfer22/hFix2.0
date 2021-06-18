package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.LimitMobChunkEvent;
import team.martin.hfix.hFix;

public class LimitMobChunkConfig {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableLimitMobChunk")){
            try {
                pm.registerEvents(new LimitMobChunkEvent(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo LimitMobChunk.");
            } catch (Exception e) {
                System.out.println("*** Módulo de LimitMobChunk não compatível.");
            }
        }
    }

    public int getMobsPerChunk(){
        return hFix.getPluginMainClass().getConfig().getInt("MobsPerChunk");
    }
}
