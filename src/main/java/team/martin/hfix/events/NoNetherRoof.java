package team.martin.hfix.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import team.martin.hfix.util.ConfigUtils;

/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 */

public class NoNetherRoof extends ConfigUtils implements Listener{
    @EventHandler(priority=EventPriority.HIGH)
    public void eventAntNetherY(PlayerMoveEvent e){
        if (e.getPlayer().getWorld().getName().equals("world_nether")){
            if ((e.getPlayer().getLocation().getY() >= 127)) {
                /*
                 * Bloco com a função de retornar a posição para 120 caso ele esteja na 127 Y
                 */
                Location newLoc = new Location(e.getPlayer().getWorld(),
                            e.getPlayer().getLocation().getX(), 120,
                            e.getPlayer().getLocation().getZ());
                    e.getPlayer().sendTitle(getFraseAntiTetoDoNether()
                                    .replace("&", "§"),
                            getFraseAntiNetherYDOWN()
                                    .replace("&", "§"));
                    e.getPlayer().teleport(newLoc);
            }
        }
    }
}
