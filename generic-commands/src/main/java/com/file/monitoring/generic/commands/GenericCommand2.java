package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("GenericCommand2")
public class GenericCommand2 extends GenericCommand {

    public GenericCommand2(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(HashMap<String, Object> context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor2_1().process(context);
    }

}
