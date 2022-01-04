package com.file.monitoring.common.configs.commands.processors;

import java.util.HashMap;

public interface CommonFileMonitoringProcessor {

    void process(HashMap<String, Object> context) throws Exception;

}
