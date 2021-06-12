package team.martin.hfix.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.martin.hfix.events.*;
import team.martin.hfix.hFix;

import java.util.Arrays;

public class ConfigUtils{
    /*
     * Não se assuste com essa classe, apenas é para administrar o arquivo config.yml.
     */
    PluginManager pm = Bukkit.getServer().getPluginManager();


    public String getFraseAntiTetoDoNether(){
        return hFix.getPluginMainClass().getConfig().getString("PhraseAntiCeilingDoNetherTOP");
    }

    public String getFraseAntiNetherYDOWN(){
        return hFix.getPluginMainClass().getConfig().getString("PhraseAntiCeilingDoNetherDOWN");
    }

    public String getPermissaoAntiVoid(){
        return hFix.getPluginMainClass().getConfig().getString("PermissionAntiVoid");
    }

    public String getAntiVoidPhrase(){
        return hFix.getPluginMainClass().getConfig().getString("AntiVoidPhrase");
    }

    public String getFraseDeBanidos(){
        return hFix.getPluginMainClass().getConfig().getString("BannedPhrase");
    }

    public String getFakePayers(){
        String[] playersOFF = {hFix.getPluginMainClass().getConfig().getString("FakePlayers")}; // Irá pegar na config.yml uma lista de Strings.
        return Arrays.toString(playersOFF);
    }

    public String getBlocosBanidos(){
        String[] blocos = {hFix.getPluginMainClass().getConfig().getString("BannedBlocks")};
        return Arrays.toString(blocos);
    }

    /*
     * getEventos, fará a execução da listagem de módulos do plugin.
     */
    public void getEventos(){
        pm.registerEvents(new VersionChecker(), (hFix.getPluginMainClass()));

        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableLagVerify")){
            if (!hFix.getPluginMainClass().getServer().getVersion().equals("3124-Spigot-66f9d3c-384e116 (MC: 1.17)")){
                try {
                    pm.registerEvents(new LagVerify(), (hFix.getPluginMainClass()));
                    System.out.println("[+] Módulo LagVerify.");
                    System.out.println(hFix.getPluginMainClass().getServer().getVersion());
                } catch (Exception e) {
                    System.out.println("*** Módulo de LagVerify não compatível.");
                }
            } else {
                System.out.println("*** Módulo de LagVerify não compatível. [1.17 ainda não está concluída]");
            }
        }

        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableAntiCeilingNether")){
            try {
                pm.registerEvents(new NoNetherRoof(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiTetoNether.");
            } catch (Exception e) {
                System.out.println("*** Módulo de AntiTetoNether não compatível.");
            }
        }

        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableFakePlayers")){
            try {
                pm.registerEvents(new FakePlayers(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo FakePlayers.");
            } catch (Exception e) {
                System.out.println("*** Módulo de FakePlayers não compatível.");
            }
        }

        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableAntiDanoDoVoid")){
            try {
                pm.registerEvents(new NoVoidDamage(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo AntiDanoDoVoid.");
            } catch (Exception e){
                System.out.println("*** Módulo de AntiDanoDoVoid não compatível.");
            }
        }

        if (hFix.getPluginMainClass().getConfig().getBoolean("EnableBlockBans")){
            try {
                pm.registerEvents(new BanThisBlock(), (hFix.getPluginMainClass()));
                System.out.println("[+] Módulo de Banimentos de blocos.");
            } catch (Exception e){
                System.out.println("*** Módulo de Banimentos de blocos não compatível.");
            }
        }
    }
}
