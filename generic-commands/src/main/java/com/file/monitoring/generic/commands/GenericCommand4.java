package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("GenericCommand4")
public class GenericCommand4 extends GenericCommand {

    public GenericCommand4(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(HashMap<String, Object> context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor4_1().process(context);
    }

}
