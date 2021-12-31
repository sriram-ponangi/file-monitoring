package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import com.file.monitoring.common.configs.commands.CommonFileMonitoringCommand;

public abstract class GenericCommand extends CommonFileMonitoringCommand {

    protected GenericProcessorsFactory genericProcessorsFactory;

    public GenericCommand(GenericProcessorsFactory genericProcessorsFactory) {
        this.genericProcessorsFactory = genericProcessorsFactory;
    }
}
