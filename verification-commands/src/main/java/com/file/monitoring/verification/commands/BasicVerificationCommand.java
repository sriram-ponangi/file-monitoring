package com.file.monitoring.verification.commands;

import com.file.monitoring.verification.commands.processors.factory.VerificationProcessorFactory;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component("BasicVerificationCommand")
public class BasicVerificationCommand extends VerificationCommand {
    public BasicVerificationCommand(VerificationProcessorFactory verificationProcessorFactory) {
        super(verificationProcessorFactory);
    }

    @Override
    protected void executeCommand(Context context) throws Exception {
        this.verificationProcessorFactory.createVerificationProcessor1().process(context);
        this.verificationProcessorFactory.createVerificationProcessor2().process(context);
        this.verificationProcessorFactory.createVerificationProcessor3().process(context);
    }
}
