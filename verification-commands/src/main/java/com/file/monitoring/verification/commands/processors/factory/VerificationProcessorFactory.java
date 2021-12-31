package com.file.monitoring.verification.commands.processors.factory;

import com.file.monitoring.verification.commands.processors.VerificationProcessor;

public interface VerificationProcessorFactory {
    VerificationProcessor createVerificationProcessor1();
    VerificationProcessor createVerificationProcessor2();
    VerificationProcessor createVerificationProcessor3();
}
