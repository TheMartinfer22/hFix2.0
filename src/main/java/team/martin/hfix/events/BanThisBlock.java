package team.martin.hfix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import team.martin.hfix.util.ConfigUtils;

/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */

public class BanThisBlock extends ConfigUtils implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent evento) {
        if (evento.getBlock().getBlockData().getAsString().equals(getBlocosBanidos() // Caso o bloco esteja na lista config.yml
                .replace("[[", "") // Na entrada da lista irá ler [[ e ]], então estou retirando isso e verificando se o jogador é operador.
                .replace("]]", "")) && (!evento.getPlayer().isOp())){
            evento.setCancelled(true); //Cancelando o evento.
            evento.getPlayer().sendMessage(getFraseDeBanidos()); // Fornecendo a mensagem ao jogador.
        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent evento) {
        if (evento.getBlock().getBlockData().getAsString().equals(getBlocosBanidos()
                .replace("[[", "")
                .replace("]]", "")) && (!evento.getPlayer().isOp())){
            evento.setCancelled(true);
            evento.getPlayer().sendMessage(getFraseDeBanidos());
        }
    }
}