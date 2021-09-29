package dev.nanosync.hfix.util;

import dev.nanosync.hfix.api.ConfigAPI;
import dev.nanosync.hfix.types.ConfigType;

public class ConfigUtil {
    public ConfigUtil(){
        new ConfigAPI(ConfigType.WORLD)
                .setValue("Enabled", true)
                .setValue("MobsLimit", 3000);

        new ConfigAPI(ConfigType.CHUNK)
                .setValue("Enabled", true)
                .setValue("MobsLimit", 5);
    }
}
