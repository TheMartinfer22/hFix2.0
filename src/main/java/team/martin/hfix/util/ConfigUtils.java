package team.martin.hfix.util;

import lombok.SneakyThrows;
import team.martin.hfix.commands.MenuCommandChat;
import team.martin.hfix.config.*;
import team.martin.hfix.hFix;


public class ConfigUtils{

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    @SneakyThrows
    public void getEventos() {
        System.out.println("Versão do servidor: " + hFix.getPluginMainClass().getServer().getVersion());

        // Carregamento das config's
        new FakePlayersConfig().enable();
        new LimitMobChunkConfig().enable();
        new NoNetherRoofConfig().enable();
        new NoVoidDamageConfig().enable();

        // Carregamento dos comandos
        hFix.getPluginMainClass().getCommand("hfix").setExecutor(new MenuCommandChat());
    }
}
