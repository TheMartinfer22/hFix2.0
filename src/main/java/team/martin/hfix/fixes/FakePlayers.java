package team.martin.hfix.fixes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import team.martin.hfix.util.ConfigUtils;

public class FakePlayers extends ConfigUtils implements Listener {


    @EventHandler(priority = EventPriority.HIGH)
    public void fixPlayerPlace (BlockPlaceEvent i){
        if (getFakePayers().contains(i.getPlayer().getName())){
            i.setCancelled(false);
        }
    }

    public void fixPlayerBreak (BlockBreakEvent i){
        if (getFakePayers().contains(i.getPlayer().getName())){
            i.setCancelled(false);
        }
    }

    public void fixPlayerInteract (PlayerInteractEvent i){
        if (getFakePayers().contains(i.getPlayer().getName())){
            i.setCancelled(false);
        }
    }

    public void fixPlayerDamage (EntityDamageEvent i){
        if (getFakePayers().contains(i.getEntity().getName())){
            i.setCancelled(false);
        }
    }
}
