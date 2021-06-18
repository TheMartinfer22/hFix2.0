
package team.martin.hfix.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import team.martin.hfix.functions.ClearChunksFunction;
import team.martin.hfix.functions.ClearMobsFunction;

public class LagVerifyEvent implements Listener {

    @EventHandler
    public void onTick(PlayerMoveEvent event){

        int tps = (int) Bukkit.getServer().getTPS()[0];

        if (tps < 10){
            new ClearChunksFunction().run();
            event.getPlayer().getWorld().getEntities().forEach(entity -> {
                if (entity.fromMobSpawner()){
                    entity.remove();
                }
                if (tps < 5){
                    new ClearMobsFunction().run();
                }
            });
        }
    }
}