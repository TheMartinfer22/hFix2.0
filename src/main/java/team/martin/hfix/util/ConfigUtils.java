package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.bloqueios.NoVoidDamage;
import team.martin.hfix.bloqueios.NoNetherRoof;
import team.martin.hfix.fixes.BanThisBlock;
import team.martin.hfix.fixes.FakePlayers;
import team.martin.hfix.hFix;

import java.util.Arrays;

public class ConfigUtils{
    /*
     * Não se assuste com essa classe, apenas é para administrar o arquivo config.yml.
     */
    PluginManager pm = Bukkit.getServer().getPluginManager(); // Irá pegar a classe Main do projeto.


    public String getFraseAntiTetoDoNether(){
        return hFix.getPluginMainClass().getConfig().getString("FraseAntiTetoDoNetherTOP"); // Irá pegar na config.yml a opção FraseAntiTetoDoNetherTOP
    }

    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("FraseAntiTetoDoNetherDOWN");
    }

    public String getPermissaoAntiVoid(){
        return hFix.getPluginMainClass().getConfig().getString("PermissaoAntiVoid");
    }

    public String getFraseDeBanidos(){
        return hFix.getPluginMainClass().getConfig().getString("FraseDeBanidos");
    }

    public String getFakePayers(){
        String[] playersOFF = {hFix.getPluginMainClass().getConfig().getString("FakePlayers")}; // Irá pegar na config.yml uma lista de Strings.
        return Arrays.toString(playersOFF);
    }

    public String getBlocosBanidos(){
        String[] blocos = {hFix.getPluginMainClass().getConfig().getString("BlocosBanidos")};
        return Arrays.toString(blocos);
    }

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    public void getEventos(){
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarAntiTetoNether")){ // Pegará na config.yml se a booleana AtivarAntiTetoNether está true
            try {
                pm.registerEvents((Listener) new NoNetherRoof(), (hFix.getPluginMainClass())); // Casp esteja irá instanciar a classe NoNetherRoof
                System.out.println("[+] Módulo AntiTetoNether.");
            } catch (Exception e) { // Para qualquer erro, irá apenas dizer que não é compatível.
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
                pm.registerEvents((Listener) new NoVoidDamage(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiDanoDoVoid.");
            } catch (Exception e){
                System.out.println("*** Módulo de AntiDanoDoVoid não compatível.");
            }
        }
        if (hFix.getPluginMainClass().getConfig().getBoolean("AtivarBanimentosDeBlocos")){
            try {
                pm.registerEvents((Listener) new BanThisBlock(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo de Banimentos de blocos.");
            } catch (Exception e){
                System.out.println("*** Módulo de Banimentos de blocos não compatível.");
            }
        }

        /*
         * Marcação de insersão de funcionalidades.
         */

    }
}
