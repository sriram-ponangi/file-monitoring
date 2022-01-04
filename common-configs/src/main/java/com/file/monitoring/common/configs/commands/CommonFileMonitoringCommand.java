package com.file.monitoring.common.configs.commands;


import com.file.monitoring.common.configs.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public abstract class CommonFileMonitoringCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonFileMonitoringCommand.class);

    @Override
    public boolean execute(HashMap<String, Object> context) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.debug("-----------------------------------------------------------");
        LOGGER.debug("[{}] :: Started Execution", this.getClass().getSimpleName());
        this.executeCommand(context);
        LOGGER.debug("[{}] :: Completed Execution. Execution Time = {}",
                this.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
        LOGGER.debug("-----------------------------------------------------------");

        return Command.CONTINUE_PROCESSING;
    }

    protected abstract void executeCommand(HashMap<String, Object> context) throws Exception;
}
