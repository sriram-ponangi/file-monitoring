package com.file.monitoring.catalog.beans;

import java.util.List;

public class ChainConfig {

    private String chain;
    private List<String> commands;

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "{" +
                "chain='" + chain + '\'' +
                ", commands=" + commands +
                '}';
    }
}
