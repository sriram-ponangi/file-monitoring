package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component("GenericCommand4")
public class GenericCommand4 extends GenericCommand {

    public GenericCommand4(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(Context context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor4_1().process(context);
    }

}
