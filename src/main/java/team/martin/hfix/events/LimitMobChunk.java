package team.martin.hfix.events;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import team.martin.hfix.config.LimitMobChunkConfig;

public class LimitMobChunk extends LimitMobChunkConfig implements Listener {
    @EventHandler
    public void checkMobs(EntitySpawnEvent event){
        Location location = event.getLocation();
        if (location.getChunk().getEntities().length >= getMobsPerChunk()){
            event.setCancelled(true);
        }
    }
}
