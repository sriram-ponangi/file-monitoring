package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component("GenericCommand3")
public class GenericCommand3 extends GenericCommand {

    public GenericCommand3(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(Context context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor3_1().process(context);
        this.genericProcessorsFactory.createGenericProcessor3_2().process(context);
    }

}
