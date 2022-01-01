package com.file.monitoring.generic.commands.processors;

import com.file.monitoring.generic.commands.dao.SomeTableDAO;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("GenericProcessor5_2")
public class GenericProcessor5_2 implements GenericProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericProcessor5_2.class);

    @Autowired
    SomeTableDAO someTableDAO;

    @Override
    public void process(Context context) throws Exception {


        context.put(this.getClass().getSimpleName(), someTableDAO.findAll());

        LOGGER.info("{} - CURRENT CHAIN CONTEXT :: {}",
                this.getClass().getSimpleName(), context);

    }
}
