package com.file.monitoring.verification.commands.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.HashMap;

public class VerificationProcessor1 implements VerificationProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerificationProcessor1.class);

    @Override
    public void process(HashMap<String, Object> context) throws Exception {
        LOGGER.info("{} - CURRENT CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);

        context.put(this.getClass().getSimpleName(), LocalTime.now());

        LOGGER.info("{} - UPDATING CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);
    }
}
