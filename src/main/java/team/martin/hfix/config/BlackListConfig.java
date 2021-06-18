package team.martin.hfix.config;

import team.martin.hfix.hFix;
import team.martin.hfix.util.ConfigUtils;

public class BlackListConfig extends ConfigUtils {
    public String[] getMobs(){
        return new String[]{hFix.getPluginMainClass().getConfig().getString("MobsBlackList")};
    }
}
