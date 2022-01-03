package com.file.monitoring.application.events.config;

import com.file.monitoring.application.events.config.beans.EventConfig;
import com.file.monitoring.application.events.config.beans.MonitoringConfigsBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


@Component
public class MonitoringEventConfiguration {

    @Value("${monitoring-events.config.yml.path}")
    private String monitoringConfigYMLPath;


    @Bean("MonitoringConfigs")
    public MonitoringConfigsBean registerActiveMonitoringEvents() throws Exception {
        Yaml yaml = new Yaml(new Constructor(MonitoringConfigsBean.class));
        InputStream inputStream = getValidMonitoringConfigs();
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

    private InputStream getValidMonitoringConfigs() throws Exception {
        File yamlFile = FileUtils.getFile(monitoringConfigYMLPath);
        if (yamlFile.isFile()) {
            return new FileInputStream(yamlFile);
        }
        return this.getClass()
                .getClassLoader()
                .getResourceAsStream(monitoringConfigYMLPath);
    }

}
