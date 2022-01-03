package com.file.monitoring.application.events.config.beans;

import lombok.Data;

import java.util.List;

@Data
public class MonitoringConfigsBean {
    private List<EventConfig> monitoringEvents;
}

