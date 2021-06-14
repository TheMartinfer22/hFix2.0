package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.BanThisBlock;
import team.martin.hfix.hFix;
import team.martin.hfix.util.ConfigUtils;

import java.util.Arrays;

public class BanThisBlockConfig extends ConfigUtils {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableBlockBans")){
            try {
                pm.registerEvents(new BanThisBlock(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo de Banimentos de blocos.");
            } catch (Exception e){
                System.out.println("*** Módulo de Banimentos de blocos não compatível.");
            }
        }
    }
    public String getBlocosBanidos(){
        String[] blocos = {hFix.getPluginMainClass().getConfig().getString("BannedBlocks")};
        return Arrays.toString(blocos);
    }

    public String getFraseDeBanidos(){
        return hFix.getPluginMainClass().getConfig().getString("BannedPhrase");
    }
}
