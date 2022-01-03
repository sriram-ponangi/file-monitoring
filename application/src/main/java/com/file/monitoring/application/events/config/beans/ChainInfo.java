package com.file.monitoring.application.events.config.beans;

import lombok.Data;

import java.util.List;

@Data
public class ChainInfo {
    private String name;
    private List<ContextParam> contextParams;
}
