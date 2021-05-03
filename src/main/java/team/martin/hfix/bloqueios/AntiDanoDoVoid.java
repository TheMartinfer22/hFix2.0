package team.martin.hfix.bloqueios;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerEvent;
import team.martin.hfix.util.ConfigUtils;

public class AntiDanoDoVoid extends ConfigUtils implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void antiDanoDoVoid(EntityDamageEvent event){

        if (event.getEntity().hasPermission(getPermissaoAntiVoid())){
            event.setCancelled(true);
        }
    }

}
