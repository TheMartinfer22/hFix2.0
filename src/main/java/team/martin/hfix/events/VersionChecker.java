package team.martin.hfix.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jsoup.Jsoup;
import java.io.IOException;

public class VersionChecker implements Listener {

    @EventHandler
    public void versionChecker(PlayerJoinEvent event) throws IOException {
        String version = "1.7";

        if (event.getPlayer().isOp()){
            String getVersion  = Jsoup.connect("https://themartinfer22.github.io/hFix/").get().title();
            if (!getVersion.contains(version)){
                event.getPlayer().sendMessage(ChatColor.RED + "[hFix] You are using an old version of the hFix plugin, update and don't forget to delete its folder.");
            }
        }
    }
}
