package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.commands.MenuCommand;
import team.martin.hfix.config.*;
import team.martin.hfix.events.extras.MenuListenerEvent;
import team.martin.hfix.events.extras.VersionCheckerEvent;
import team.martin.hfix.hFix;

public class ConfigUtils{
    PluginManager pm = Bukkit.getServer().getPluginManager();

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    public void getEventos(){
        System.out.println("Versão do servidor: " + hFix.getPluginMainClass().getServer().getVersion());
        pm.registerEvents(new VersionCheckerEvent(), (hFix.getPluginMainClass()));
        pm.registerEvents(new MenuListenerEvent(), (hFix.getPluginMainClass()));


        // Carregamento das config's

        new BanThisBlockConfig().enable();
        new FakePlayersConfig().enable();
        new LagVerifyConfig().enable();
        new LimitMobChunkConfig().enable();
        new NoNetherRoofConfig().enable();
        new NoVoidDamageConfig().enable();


        // Carregamento de Comandos
        hFix.getPluginMainClass().getCommand("hfix").setExecutor(new MenuCommand());
    }
}
