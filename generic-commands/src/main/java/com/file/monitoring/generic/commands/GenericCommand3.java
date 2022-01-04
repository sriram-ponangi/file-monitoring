package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("GenericCommand3")
public class GenericCommand3 extends GenericCommand {

    public GenericCommand3(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(HashMap<String, Object> context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor3_1().process(context);
        this.genericProcessorsFactory.createGenericProcessor3_2().process(context);
    }

}
