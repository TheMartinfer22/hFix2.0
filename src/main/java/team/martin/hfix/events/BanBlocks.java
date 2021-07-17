package team.martin.hfix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import team.martin.hfix.config.BanThisBlockConfig;

import java.util.Arrays;

/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */
public class BanBlocks extends BanThisBlockConfig implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent event) {
        Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
            if (objeto.equals(event.getBlock().getType().toString()) && !event.getPlayer().isOp()){
                event.setCancelled(true);
                event.getPlayer().sendMessage(getFraseDeBanidos());
            }
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
            if (objeto.equals(event.getBlock().getType().toString()) && !event.getPlayer().isOp()){
                event.setCancelled(true);
                event.getPlayer().sendMessage(getFraseDeBanidos());
            }
        });
    }

    @EventHandler
        public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
                if (objeto.equals(event.getClickedBlock().getType().toString()) && !event.getPlayer().isOp()){
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(getFraseDeBanidos());
                }
            });
        }
    }
}