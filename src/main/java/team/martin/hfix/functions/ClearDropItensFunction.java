package team.martin.hfix.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;

import java.util.Objects;

public class ClearDropItensFunction {
    public void run(){
        Bukkit.getWorlds().forEach(world -> {
            world.getEntities().forEach(entity -> {
                if (entity instanceof Item){
                    entity.remove();
                }
            });
        });
    }

    public void run(String world){
        Objects.requireNonNull(Bukkit.getWorld(world)).getEntities().forEach(entity -> {
            if (entity instanceof Item){
                entity.remove();
            }
        });
    }
}
