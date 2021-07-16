package team.martin.hfix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import team.martin.hfix.config.BanThisBlockConfig;

import java.util.Arrays;


/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */
public class BanItem extends BanThisBlockConfig implements Listener {

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
    public void onItemInteractEvent(PlayerInteractEvent event){
        if (event.getItem() == null) return;
        Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
            if (objeto.equals(event.getItem().getType().toString()) && !event.getPlayer().isOp()){
                event.setCancelled(true);
                event.getPlayer().sendMessage(getFraseDeBanidos());
            }
        });
    }

//    @EventHandler
//    public void playerDropItem(PlayerDropItemEvent event){
//        Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
//            if (objeto.equals(event.getItemDrop().getType().toString()) && !event.getPlayer().isOp()){
//                event.setCancelled(true);
//                event.getPlayer().sendMessage(getFraseDeBanidos());
//            }
//        });
//    }

//    @EventHandler
//    public void onPlayerGetItem(EntityPickupItemEvent event) {
//        Arrays.stream(getBlocosBanidos().split(", ")).forEach(objeto -> {
//            if (objeto.equals(event.getItem().getType().toString()) && !event.getEntity().isOp()){
//                event.setCancelled(true);
//            }
//        });
//    }
}