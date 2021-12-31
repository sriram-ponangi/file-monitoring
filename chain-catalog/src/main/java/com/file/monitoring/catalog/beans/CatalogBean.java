package com.file.monitoring.catalog.beans;

import java.util.List;

public class CatalogBean {
    private List<ChainConfig> catalog;

    public List<ChainConfig> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<ChainConfig> catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "{" +
                "catalog=" + catalog +
                '}';
    }
}
