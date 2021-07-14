package team.martin.hfix.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import team.martin.hfix.config.BlackListConfig;

import java.util.Arrays;
import java.util.Objects;

public class ClearMobsFunction extends BlackListConfig{
    String mobs = Arrays.asList(getMobs()).toString().replace("]]", "").replace("[[", "");
    public void run(){
        Bukkit.getServer().getWorlds().forEach(world -> {
            world.getEntities().forEach(entity -> {
                if (!((mobs.contains(entity.getType().toString())) || entity instanceof Player || entity.getCustomName() != null || entity instanceof Item)){
                    entity.remove();
                }
            });
            System.out.println(ChatColor.GREEN + "[hFix] Was cleaned " + world.getEntities().size() + " entities [" + world.getName() + "]");
        });
    }

    public void run(String world){
        Objects.requireNonNull(Bukkit.getWorld(world)).getEntities().forEach(entity -> {
            if (!((mobs.contains(entity.getType().toString())) || entity instanceof Player || entity.getCustomName() != null || entity instanceof Item)){
                entity.remove();
            }
        });
    }
}
