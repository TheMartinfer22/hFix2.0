package dev.nanosync.hfix.features.mob;

import dev.nanosync.hfix.api.ConfigAPI;
import dev.nanosync.hfix.types.ConfigType;
import dev.nanosync.hfix.fabric.ChunkFabric;
import dev.nanosync.hfix.fabric.WorldFabric;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class LimitMobsFeature implements Listener {

    private final Integer chunkMobLimit = new ConfigAPI(ConfigType.CHUNK).getValueAsInteger("MobsLimit");
    private final Integer worldMobLimit = new ConfigAPI(ConfigType.WORLD).getValueAsInteger("MobsLimit");

    @EventHandler
    public void chunkLimiter(EntitySpawnEvent event){
        Chunk chunk = event.getLocation().getChunk();
        if (new ChunkFabric(chunk).getMobs().size() > chunkMobLimit){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void worldLimiter(EntitySpawnEvent event){
        World world = event.getLocation().getWorld();
        if (new WorldFabric(world).getMobs().size() > worldMobLimit){
            event.setCancelled(true);
        }
    }
}
