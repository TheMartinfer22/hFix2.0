package dev.nanosync.hfix.fabric;

import org.bukkit.World;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;

public class WorldFabric {

    private final World world;

    public WorldFabric(World world){
        this.world = world;
    }

    public WorldFabric clearDroppedItens(){
        getDroppedItens().forEach(Entity::remove);
        return this;
    }

    public WorldFabric clearDroppedItensExcept(List<String> exceptItens){
        getDroppedItens().forEach(entity -> {
            if (exceptItens.stream().noneMatch((item) -> item.equals(entity.getName()))){
                entity.remove();
            }
        });
        return this;
    }

    public WorldFabric clearMobs(){
        getMobs().forEach(Entity::remove);
        return this;
    }

    public WorldFabric clearMobsExcept(List<String> exceptMobs){
        getMobs().forEach(mob -> {
            if (exceptMobs.stream().noneMatch((mobExcepted) -> mobExcepted.equals(mob.getName()))){
                mob.remove();
            }
        });
        return this;
    }

    public List<Entity> getDroppedItens(){
        List<Entity> itensList = new ArrayList<>();
        world.getEntities().forEach(entity -> {
            if (entity instanceof Item) itensList.add(entity);
        });
        return itensList;
    }

    public List<Entity> getMobs(){
        List<Entity> mobsList = new ArrayList<>();
        world.getEntities().forEach(entity -> {
            if (entity instanceof Animals || entity instanceof Monster) mobsList.add(entity);
        });
        return mobsList;
    }
}
