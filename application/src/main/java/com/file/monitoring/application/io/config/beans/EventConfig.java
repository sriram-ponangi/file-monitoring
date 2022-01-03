package com.file.monitoring.application.io.config.beans;

import lombok.Data;
import java.util.List;

@Data
public class EventConfig {
    private String path;
    private String name;
    private boolean active;
    private List<EventInfo> eventsInfo;

}

