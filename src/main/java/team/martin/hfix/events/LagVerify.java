
package team.martin.hfix.events;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;

public class LagVerify implements Listener {

    @EventHandler
    public void onTick(PlayerMoveEvent event){

        int tps = (int) Bukkit.getServer().getTPS()[0];
//        System.out.println(Bukkit.getServer().getTPS()[0]);

        if (tps < 10){
            Chunk[] loadedChunks = event.getPlayer().getWorld().getLoadedChunks();
//            Bukkit.getServer().broadcastMessage("UNIT CHUNKS LOADED: " + event.getPlayer().getWorld().getLoadedChunks().length);
            Arrays.asList(loadedChunks).forEach(Chunk::unload);
            event.getPlayer().getWorld().getEntities().forEach(entity -> {
                if (entity.fromMobSpawner()){
                    entity.remove();
                }});
        }
    }
}