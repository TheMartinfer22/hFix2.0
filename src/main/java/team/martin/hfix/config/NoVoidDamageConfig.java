package team.martin.hfix.config;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.NoVoidDamage;
import team.martin.hfix.hFix;

public class NoVoidDamageConfig {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    public void enable(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableAntiDanoDoVoid")){
            try {
                pm.registerEvents(new NoVoidDamage(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiDanoDoVoid.");
            } catch (Exception e){
                System.out.println("*** Módulo de AntiDanoDoVoid não compatível.");
            }
        }
    }

    public String getPermissaoAntiVoid(){
        return hFix.getPluginMainClass().getConfig().getString("PermissionAntiVoid");
    }

    public String getAntiVoidPhrase(){
        return hFix.getPluginMainClass().getConfig().getString("AntiVoidPhrase");
    }
}
