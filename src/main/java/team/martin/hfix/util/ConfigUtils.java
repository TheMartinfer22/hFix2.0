package team.martin.hfix.util;

import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.bloqueios.AntNetherY;
import team.martin.hfix.fixes.FakePlayers;
import team.martin.hfix.hFix;

import java.util.Arrays;

public class ConfigUtils{
    PluginManager pm = Bukkit.getServer().getPluginManager();


    public String getFraseAntiNetherYTOP(){
        return hFix.getPluginMainClass().getConfig().getString("FraseAntiNetherYTOP");
    }
    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("FraseAntiNetherYDOWN");
    }
    public String getFakePayers(){
        String[] playersOFF = {hFix.getPluginMainClass().getConfig().getString("FakePlayers")};
        return Arrays.toString(playersOFF);
    }


    public void getEventos(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarAntNetherY")){
            try {
                pm.registerEvents((Listener) new AntNetherY(), (hFix.getPluginMainClass()));
                System.out.println(ChatColor.GREEN + "[+] Módulo AntNetherY.");
            } catch (Exception e) {
                System.out.println(ChatColor.RED + "*** Módulo de AntNetherY não compatível.");
            }
        }
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarFakePlayers")){
            try {
                pm.registerEvents((Listener) new FakePlayers(), (hFix.getPluginMainClass()));
                System.out.println(ChatColor.GREEN + "[+] Módulo FakePlayers.");
            } catch (Exception e) {
                System.out.println(ChatColor.RED + "*** Módulo de FakePlayers não compatível.");
            }
        }

        /*
         * Marcação de insersão de funcionalidades.
         */

    }
}
