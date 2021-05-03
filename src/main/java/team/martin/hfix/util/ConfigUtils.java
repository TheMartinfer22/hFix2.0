package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.bloqueios.AntiDanoDoVoid;
import team.martin.hfix.bloqueios.AntiTetoDoNether;
import team.martin.hfix.fixes.FakePlayers;
import team.martin.hfix.hFix;

import java.util.Arrays;

public class ConfigUtils{
    PluginManager pm = Bukkit.getServer().getPluginManager();


    public String getFraseAntiTetoDoNether(){
        return hFix.getPluginMainClass().getConfig().getString("raseAntiTetoDoNetherTOP");
    }
    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("raseAntiTetoDoNetherDOWN");
    }
    public String getPermissaoAntiVoid(){
        return hFix.getPluginMainClass().getConfig().getString("PermissaoAntiVoid");
    }
    public String getFakePayers(){
        String[] playersOFF = {hFix.getPluginMainClass().getConfig().getString("FakePlayers")};
        return Arrays.toString(playersOFF);
    }


    public void getEventos(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarAntiTetoNether")){
            try {
                pm.registerEvents((Listener) new AntiTetoDoNether(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiTetoNether.");
            } catch (Exception e) {
                System.out.println("*** Módulo de AntiTetoNether não compatível.");
            }
        }
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarFakePlayers")){
            try {
                pm.registerEvents((Listener) new FakePlayers(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo FakePlayers.");
            } catch (Exception e) {
                System.out.println("*** Módulo de FakePlayers não compatível.");
            }
        }
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarAntiDanoDoVoid")){
            try {
                pm.registerEvents((Listener) new AntiDanoDoVoid(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiDanoDoVoid.");
            } catch (Exception e){
                System.out.println("*** Módulo de AntiDanoDoVoid não compatível.");
            }
        }

        /*
         * Marcação de insersão de funcionalidades.
         */

    }
}
