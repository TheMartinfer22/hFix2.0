package team.martin.hfix.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;

import java.util.Arrays;

public class ClearChunksFunction {
    public void run (){
        Bukkit.getServer().getWorlds().forEach(world -> {
            System.out.println(ChatColor.GREEN + "[hFix] Was cleaned " + world.getLoadedChunks().length + " chunk's [" + world.getName() + "]");
            Arrays.asList(world.getLoadedChunks()).forEach(Chunk::unload);
        });
    }
}
