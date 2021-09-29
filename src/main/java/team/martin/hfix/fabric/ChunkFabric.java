package team.martin.hfix.fabric;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Mob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkFabric {

    private final Chunk chunk;

    public ChunkFabric(Chunk chunk) {
        this.chunk = chunk;
    }

    public ChunkFabric clearDroppedItens(){
        getDroppedItens().forEach(Entity::remove);
        return this;
    }

    public ChunkFabric clearDroppedItensExcept(List<String> exceptItens){
        getDroppedItens().forEach(entity -> {
            if (exceptItens.stream().noneMatch((item) -> item.equals(entity.getName()))){
                entity.remove();
            }
        });
        return this;
    }

    public ChunkFabric clearMobs(){
        getMobs().forEach(Entity::remove);
        return this;
    }

    public ChunkFabric clearMobsExcept(List<String> exceptMobs){
        getMobs().forEach(entity -> {
            if (exceptMobs.stream().noneMatch((mob) -> mob.equals(entity.getName()))){
                entity.remove();
            }
        });
        return this;
    }

    public List<Entity> getDroppedItens(){
        List<Entity> itensSet = new ArrayList<>();
        Arrays.stream(chunk.getEntities()).forEach(entity -> {
            if (entity instanceof Item) itensSet.add(entity);
        });
        return itensSet;
    }

    public List<Entity> getMobs(){
        List<Entity> mobsList = new ArrayList<>();
        Arrays.stream(chunk.getEntities()).forEach(entity -> {
            if (entity instanceof Mob) mobsList.add(entity);
        });
        return mobsList;
    }
}
