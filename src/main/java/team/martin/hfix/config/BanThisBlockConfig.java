package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.Nullable;
import team.martin.hfix.events.BanItem;
import team.martin.hfix.hFix;
import team.martin.hfix.util.ConfigUtils;

import java.util.Arrays;
import java.util.Objects;

public class BanThisBlockConfig extends ConfigUtils {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableBlockBans")){
            try {
                pm.registerEvents(new BanItem(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo de Banimentos de blocos.");
            } catch (Exception e){
                System.out.println("*** Módulo de Banimentos de blocos não compatível.");
            }
        }
    }
    public String getBlocosBanidos(){
        @Nullable String blocos = hFix.getPluginMainClass().getConfig().getString("BannedItens");
        return Objects.requireNonNull(blocos).replace("[", "").replace("]", ""); // Sim, eu não usei o replaceAll com regex pq queria ter fácil visibilidade.
    }

    public String getFraseDeBanidos(){
        return hFix.getPluginMainClass().getConfig().getString("BannedPhrase");
    }
}
