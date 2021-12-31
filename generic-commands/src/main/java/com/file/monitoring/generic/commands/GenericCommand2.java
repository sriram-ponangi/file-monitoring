package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component("GenericCommand2")
public class GenericCommand2 extends GenericCommand {

    public GenericCommand2(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(Context context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor2_1().process(context);
    }

}
