package team.martin.hfix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import team.martin.hfix.util.ConfigUtils;

public class FakePlayers extends ConfigUtils implements Listener {

    /*
     * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
     * Não causará problemas de desempenho.
     */

    @EventHandler(priority = EventPriority.HIGH)
    public void fixPlayerPlace (BlockPlaceEvent evento){
        if (getFakePayers().contains(evento.getPlayer().getName())){ // Pegando o nome do jogador falso na lista config.yml
            evento.setCancelled(false); // Não cancelar o evento e permitir que ele prossiga.
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void fixPlayerBreak (BlockBreakEvent evento){
        if (getFakePayers().contains(evento.getPlayer().getName())){
            evento.setCancelled(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void fixPlayerInteract (PlayerInteractEvent evento){
        if (getFakePayers().contains(evento.getPlayer().getName())){
            evento.setCancelled(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void fixPlayerDamage (EntityDamageEvent evento){
        if (getFakePayers().contains(evento.getEntity().getName())){
            evento.setCancelled(false);
        }
    }
}
