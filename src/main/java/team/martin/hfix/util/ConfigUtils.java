package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.jsoup.Jsoup;
import team.martin.hfix.commands.MenuCommandChat;
import team.martin.hfix.config.*;
import team.martin.hfix.hFix;

import java.io.IOException;

public class ConfigUtils{

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    public void getEventos() throws IOException {
        System.out.println("Versão do servidor: " + hFix.getPluginMainClass().getServer().getVersion());


        // Version Manager
        String getVersion  = Jsoup.connect("https://themartinfer22.github.io/hFix/").get().title();
        String version = "1.9.1";
        if (!getVersion.contains(version)){
            System.out.println(ChatColor.RED + "----------------------------------------------------------");
            System.out.println(ChatColor.RED + "[hFix] You are using an old version of the hFix plugin, update and don't forget to delete its folder.");
            System.out.println(ChatColor.RED + "----------------------------------------------------------");
        }

        // Carregamento das config's
        new FakePlayersConfig().enable();
        new LagVerifyConfig().enable();
        new LimitMobChunkConfig().enable();
        new NoNetherRoofConfig().enable();
        new NoVoidDamageConfig().enable();
        new BanThisBlockConfig().enable();

        // Carregamento dos comandos
        hFix.getPluginMainClass().getCommand("hfix").setExecutor(new MenuCommandChat());
    }
}
