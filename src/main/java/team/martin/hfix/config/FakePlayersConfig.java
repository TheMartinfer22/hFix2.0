package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.FakePlayers;
import team.martin.hfix.hFix;

import java.util.Arrays;

public class FakePlayersConfig {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableFakePlayers")){
            try {
                pm.registerEvents(new FakePlayers(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo FakePlayers.");
            } catch (Exception e) {
                System.out.println("*** Módulo de FakePlayers não compatível.");
            }
        }
    }
    public String getFakePayers(){
        String[] playersOFF = {hFix.getPluginMainClass().getConfig().getString("FakePlayers")}; // Irá pegar na config.yml uma lista de Strings.
        return Arrays.toString(playersOFF);
    }
}
