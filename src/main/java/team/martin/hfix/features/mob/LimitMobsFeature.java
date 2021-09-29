package team.martin.hfix.features.mob;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import team.martin.hfix.fabric.ChunkFabric;
import team.martin.hfix.fabric.WorldFabric;

public class LimitMobsFeature implements Listener {

    @EventHandler
    public void chunkLimiter(EntitySpawnEvent event){
        Chunk chunk = event.getLocation().getChunk();
        if (new ChunkFabric(chunk).getMobs().size() > 10){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void worldLimiter(EntitySpawnEvent event){
        World world = event.getLocation().getWorld();
        if (new WorldFabric(world).getMobs().size() > 10){
            event.setCancelled(true);
        }
    }
}
