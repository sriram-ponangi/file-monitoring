package com.file.monitoring.verification.commands;

import com.file.monitoring.verification.commands.processors.factory.VerificationProcessorFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("BasicVerificationCommand")
public class BasicVerificationCommand extends VerificationCommand {
    public BasicVerificationCommand(VerificationProcessorFactory verificationProcessorFactory) {
        super(verificationProcessorFactory);
    }

    @Override
    protected void executeCommand(HashMap<String, Object> context) throws Exception {
        this.verificationProcessorFactory.createVerificationProcessor1().process(context);
        this.verificationProcessorFactory.createVerificationProcessor2().process(context);
        this.verificationProcessorFactory.createVerificationProcessor3().process(context);
    }
}
