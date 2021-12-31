package com.file.monitoring.common.configs.commands.processors;

import org.apache.commons.chain.Context;

public interface CommonFileMonitoringProcessor {

    void process(Context context) throws Exception;

}
