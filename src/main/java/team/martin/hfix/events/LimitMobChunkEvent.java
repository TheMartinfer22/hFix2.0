package team.martin.hfix.events;

import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import team.martin.hfix.config.LimitMobChunkConfig;

public class LimitMobChunkEvent extends LimitMobChunkConfig implements Listener {
    @EventHandler
    public void checkMobs(EntitySpawnEvent event){
        Location location = event.getLocation();
        if (!(event instanceof Monster)) return;
        if (!(event instanceof Animals)) return;
        if (location.getChunk().getEntities().length >= getMobsPerChunk()){
            event.setCancelled(true);
        }
    }
}
