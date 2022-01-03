package com.file.monitoring.application.io.config;

import com.file.monitoring.application.io.config.beans.EventConfig;
import com.file.monitoring.application.io.config.beans.MonitoringConfigsBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


@Component
public class MonitoringEventConfiguration {

    @Value("${monitoring-events.config.yml.path}")
    private String monitoringConfigYMLPath;


    @Bean("MonitoringConfigs")
    public MonitoringConfigsBean registerActiveMonitoringEvents() {
        Yaml yaml = new Yaml(new Constructor(MonitoringConfigsBean.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(monitoringConfigYMLPath);
        MonitoringConfigsBean monitoringConfigsBean = yaml.load(inputStream);

        return monitoringConfigsBean;
    }

    @Bean("ActiveMonitoringEventConfigsMap")
    public HashMap<String, EventConfig> configureActiveEvents(
            @Qualifier("MonitoringConfigs") MonitoringConfigsBean monitoringConfigsBean) {
        final HashMap<String, EventConfig> map = new HashMap<>();

        List<EventConfig> eventConfigs = monitoringConfigsBean.getMonitoringEvents();
        eventConfigs.stream().filter(EventConfig::isActive).forEach(event -> {
            map.put(event.getPath(), event);
        });

        return map;
    }

}
