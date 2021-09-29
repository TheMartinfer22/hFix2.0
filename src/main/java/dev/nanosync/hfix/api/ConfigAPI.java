package dev.nanosync.hfix.api;

import dev.nanosync.hfix.types.ConfigType;
import dev.nanosync.hfix.util.ConfigUtil;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigAPI {

    private final File file;
    private final YamlConfiguration yamlConfiguration;

    @SneakyThrows
    public ConfigAPI(ConfigType configTypes){
        file = new File("plugins/hFix/" + configTypes.getFileName() + ".yml");
        yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()){
            file.createNewFile();
            new ConfigUtil();
        }
    }

    @SneakyThrows
    public String getValueAsString(String path){
        if (yamlConfiguration.get(path) == null){
            return "Not Found";
        }
        return yamlConfiguration.getString(path);
    }

    @SneakyThrows
    public Integer getValueAsInteger(String path){
        if (yamlConfiguration.get(path) == null){
            return 0;
        }
        return yamlConfiguration.getInt(path);
    }

    @SneakyThrows
    public Object get(String path){
        if (yamlConfiguration.get(path) == null){
            return null;
        }
        return yamlConfiguration.getInt(path);
    }

    @SneakyThrows
    public ConfigAPI setValue(String path, Object value){
        yamlConfiguration.set(path, value);
        yamlConfiguration.save(file);
        return this;
    }
}
