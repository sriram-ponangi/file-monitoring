package com.file.monitoring.verification.commands.processors.factory;

import com.file.monitoring.verification.commands.processors.VerificationProcessor;
import com.file.monitoring.verification.commands.processors.VerificationProcessor1;
import com.file.monitoring.verification.commands.processors.VerificationProcessor2;
import com.file.monitoring.verification.commands.processors.VerificationProcessor3;
import org.springframework.stereotype.Component;

@Component
public class VerificationProcessorFactoryImpl implements VerificationProcessorFactory {
    @Override
    public VerificationProcessor createVerificationProcessor1() {
        return new VerificationProcessor1();
    }

    @Override
    public VerificationProcessor createVerificationProcessor2() {
        return new VerificationProcessor2();
    }

    @Override
    public VerificationProcessor createVerificationProcessor3() {
        return new VerificationProcessor3();
    }
}
