package com.file.monitoring.generic.commands.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.HashMap;

@Component("GenericProcessor2_1")
public class GenericProcessor2_1 implements GenericProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericProcessor2_1.class);

    @Override
    public void process(HashMap<String, Object> context) throws Exception {
        LOGGER.info("{} - CURRENT CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);

        context.put(this.getClass().getSimpleName(), LocalTime.now());

        LOGGER.info("{} - UPDATING CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);

    }
}
