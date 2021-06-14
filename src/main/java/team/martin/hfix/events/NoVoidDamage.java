package team.martin.hfix.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import team.martin.hfix.config.NoVoidDamageConfig;

/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */

public class NoVoidDamage extends NoVoidDamageConfig implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void antiDanoDoVoid(EntityDamageEvent event){
        if (event.getEntity().hasPermission(getPermissaoAntiVoid()) && (event.getEntity().getLocation().getY() < -35)){
            Location spawnpoint = Bukkit.getServer().getWorld("world").getSpawnLocation();
            event.setCancelled(true);
            try {
                event.getEntity().teleport(spawnpoint);
                event.getEntity().sendMessage(getAntiVoidPhrase());
            } catch(NullPointerException ex){
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn " + event.getEntity().getName());
            }
        }
    }
}
