package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.config.*;
import team.martin.hfix.events.*;
import team.martin.hfix.hFix;

public class ConfigUtils{
    PluginManager pm = Bukkit.getServer().getPluginManager();

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    public void getEventos(){
        System.out.println("Versão do servidor: " + hFix.getPluginMainClass().getServer().getVersion());
        pm.registerEvents(new VersionChecker(), (hFix.getPluginMainClass()));

        // Carregamento das config's

        new BanThisBlockConfig().enable();
        new FakePlayersConfig().enable();
        new LagVerifyConfig().enable();
        new LimitMobChunkConfig().enable();
        new NoNetherRoofConfig().enable();
        new NoVoidDamageConfig().enable();
    }
}
