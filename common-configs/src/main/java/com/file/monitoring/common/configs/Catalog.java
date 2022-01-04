package com.file.monitoring.common.configs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Catalog {
    private static final Map<String, Chain> catalog = new ConcurrentHashMap<>();

    public void addChain(Chain chain) throws Exception {
        if (chain == null) {
            throw new Exception("Invalid Argument Exception");
        }
        catalog.put(chain.getName(), chain);
    }

    public Chain getChain(String chainName) throws Exception {
        if (chainName == null) {
            throw new Exception("Invalid Argument Exception");
        }
        return catalog.get(chainName);
    }
}
