package team.martin.hfix.util;

import org.bukkit.ChatColor;

import java.io.IOException;

public class LogUtils {

    public void getInit() throws IOException {
        ConfigUtils cfg = new ConfigUtils();
        System.out.println(ChatColor.GREEN +
                "  _       _____   _        " + System.lineSeparator() + ChatColor.GREEN +
                " | |__   |  ___| (_) __  __" + System.lineSeparator() + ChatColor.GREEN +
                " | '_ \\  | |_    | | \\ \\/ /" + System.lineSeparator() + ChatColor.GREEN +
                " | | | | |  _|   | |  >  < " + System.lineSeparator() + ChatColor.GREEN +
                " |_| |_| |_|     |_| /_/\\_\\" + System.lineSeparator() + ChatColor.GREEN +
                "                           ");
        cfg.getEventos();
        System.out.println();
    }

    public void getExit() {
        System.out.println(ChatColor.RED + "hFix está se desligando corretamente");
    }
}
