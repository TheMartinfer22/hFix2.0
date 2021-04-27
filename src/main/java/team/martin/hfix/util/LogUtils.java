package team.martin.hfix.util;

import org.bukkit.ChatColor;

public class LogUtils {

    public void getInit(){
        ConfigUtils cfg = new ConfigUtils();
        System.out.println(ChatColor.GREEN + "  _       _____   _        \n" +
                " | |__   |  ___| (_) __  __\n" +
                " | '_ \\  | |_    | | \\ \\/ /\n" +
                " | | | | |  _|   | |  >  < \n" +
                " |_| |_| |_|     |_| /_/\\_\\\n" +
                "                           ");
        cfg.getEventos();
        System.out.println();
    }

    public void getExit() {
        System.out.println(ChatColor.RED + "hFix está se desligando corretamente");
    }
}
