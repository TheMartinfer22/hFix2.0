package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.FakePlayersEvent;
import team.martin.hfix.hFix;

import java.util.List;

public class FakePlayersConfig {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableFakePlayers")){
            try {
                pm.registerEvents(new FakePlayersEvent(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo FakePlayers.");
            } catch (Exception e) {
                System.out.println("*** Módulo de FakePlayers não compatível.");
            }
        }
    }
    public List<String> getFakePayers(){
        return hFix.getPluginMainClass().getConfig().getStringList("FakePlayers");
    }
}
