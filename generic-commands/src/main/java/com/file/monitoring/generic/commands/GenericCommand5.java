package com.file.monitoring.generic.commands;

import com.file.monitoring.generic.commands.processors.factory.GenericProcessorsFactory;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component("GenericCommand5")
public class GenericCommand5 extends GenericCommand {

    public GenericCommand5(GenericProcessorsFactory genericProcessorsFactory) {
        super(genericProcessorsFactory);
    }

    @Override
    public void executeCommand(Context context) throws Exception {
        this.genericProcessorsFactory.createGenericProcessor5_1().process(context);
        this.genericProcessorsFactory.createGenericProcessor5_2().process(context);
    }

}
