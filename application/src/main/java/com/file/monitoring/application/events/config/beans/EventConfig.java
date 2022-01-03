package com.file.monitoring.application.events.config.beans;

import lombok.Data;
import java.util.List;

@Data
public class EventConfig {
    private String path;
    private long pollInterval;
    private String name;
    private boolean active;
    private List<EventInfo> eventsInfo;

}

