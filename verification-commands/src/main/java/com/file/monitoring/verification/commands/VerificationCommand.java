package com.file.monitoring.verification.commands;

import com.file.monitoring.common.configs.commands.CommonFileMonitoringCommand;
import com.file.monitoring.verification.commands.processors.factory.VerificationProcessorFactory;

public abstract class VerificationCommand extends CommonFileMonitoringCommand {

    protected VerificationProcessorFactory verificationProcessorFactory;

    public VerificationCommand(VerificationProcessorFactory verificationProcessorFactory) {
        this.verificationProcessorFactory = verificationProcessorFactory;
    }
}
