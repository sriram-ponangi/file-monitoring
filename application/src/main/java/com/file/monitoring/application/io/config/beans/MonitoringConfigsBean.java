package com.file.monitoring.application.io.config.beans;

import lombok.Data;

import java.util.List;

@Data
public class MonitoringConfigsBean {
    private List<EventConfig> monitoringEvents;
}

