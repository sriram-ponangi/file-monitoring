package com.file.monitoring.catalog.constants;

public enum ChainNames {
    ASCENDING_CHAIN("AscendingChain"),
    DESCENDING_CHAIN("DescendingChain"),
    VERIFICATION_CHAIN("VerificationChain"),

    ;

    private String chainName;

    ChainNames(String chainName) {
        this.chainName = chainName;
    }

    public String getChainName() {
        return chainName;
    }
}
