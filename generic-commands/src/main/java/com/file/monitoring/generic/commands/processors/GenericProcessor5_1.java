package com.file.monitoring.generic.commands.processors;

import com.file.monitoring.generic.commands.dao.NamesDAO;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component("GenericProcessor5_1")
public class GenericProcessor5_1 implements GenericProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericProcessor5_1.class);

    @Autowired
    NamesDAO namesDAO;

    @Override
    public void process(Context context) throws Exception {

        context.put(this.getClass().getSimpleName(), namesDAO.findAll());

        LOGGER.info("{} - CURRENT CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);

    }
}
