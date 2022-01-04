package com.file.monitoring.common.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;

public final class Chain {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chain.class);

    private LinkedList<Command> commands = new LinkedList<>();
    private final String name;

    public Chain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void execute(HashMap<String, Object> context) {
        for (Command command : this.commands) {
            boolean chainMustEnd;
            try {
                chainMustEnd = command.execute(context);
            } catch (Exception e) {
                chainMustEnd = Command.COMPLETE_PROCESSING;
                LOGGER.error("Stopping Chain Execution. ", e);
            }

            if (chainMustEnd){
                break;
            }
        }
    }
}
