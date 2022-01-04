package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("GenericCommand1")
public class GenericCommand1 extends GenericCommand {

    public GenericCommand1(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(HashMap<String, Object> context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor1_1().process(context);
        this.genericProcessorsFactory.createGenericProcessor1_2().process(context);
    }

}
