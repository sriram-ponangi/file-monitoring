package com.file.monitoring.application.io.config.beans;

import com.file.monitoring.application.io.constants.MonitoringEventType;
import lombok.Data;

@Data
public class EventInfo {
    private MonitoringEventType type;
    private boolean active;
    private ChainInfo chainInfo;
}
