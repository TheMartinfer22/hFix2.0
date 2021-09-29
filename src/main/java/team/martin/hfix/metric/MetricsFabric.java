package team.martin.hfix.metric;

import org.bukkit.plugin.java.JavaPlugin;

public class MetricsFabric {
    public MetricsFabric(JavaPlugin javaPlugin, int pluginID){
        new MetricsAPI(javaPlugin, pluginID);
    }
}
