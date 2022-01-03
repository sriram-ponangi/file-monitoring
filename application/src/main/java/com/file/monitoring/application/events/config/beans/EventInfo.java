package com.file.monitoring.application.events.config.beans;

import com.file.monitoring.application.events.constants.MonitoringEventType;
import lombok.Data;

@Data
public class EventInfo {
    private MonitoringEventType type;
    private boolean active;
    private ChainInfo chainInfo;
}
