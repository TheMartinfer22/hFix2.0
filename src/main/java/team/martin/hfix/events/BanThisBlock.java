package team.martin.hfix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import team.martin.hfix.config.BanThisBlockConfig;


/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */

public class BanThisBlock extends BanThisBlockConfig implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent evento) {
        if (evento.getBlock().getBlockData().getAsString().equals(getBlocosBanidos()
                .replace("[[", "")
                .replace("]]", "")) && (!evento.getPlayer().isOp())) {
            evento.setCancelled(true);
            evento.getPlayer().sendMessage(getFraseDeBanidos());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent evento) {
        if (evento.getBlock().getBlockData().getAsString().equals(getBlocosBanidos()
                .replace("[[", "")
                .replace("]]", "")) && (!evento.getPlayer().isOp())) {
            evento.setCancelled(true);
            evento.getPlayer().sendMessage(getFraseDeBanidos());
        }
    }
}