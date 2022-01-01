package com.file.monitoring.application;

import com.file.monitoring.catalog.constants.ChainNames;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.file.monitoring"})
public class FileMonitoringApp implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileMonitoringApp.class);

    @Autowired
    @Qualifier("ChainYMLCatalog")
    private Catalog chainYMLCatalog;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(FileMonitoringApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        try {

            LOGGER.info("======================================================================================================");
            LOGGER.info("EXECUTING CHAIN YAML CATALOG: ");
            LOGGER.info("======================================================================================================\n\n");


            Context ascendingChainContext1 = new ContextBase();
            Command ascendingChain1 = chainYMLCatalog.getCommand(ChainNames.ASCENDING_CHAIN.getChainName());
            ascendingChain1.execute(ascendingChainContext1);

            LOGGER.info("======================================================================================================\n\n");
            LOGGER.info("======================================================================================================\n\n");

            Context descendingChainContext1 = new ContextBase();
            Command descendingChain1 = chainYMLCatalog.getCommand(ChainNames.DESCENDING_CHAIN.getChainName());
            descendingChain1.execute(descendingChainContext1);

            LOGGER.info("======================================================================================================\n\n");
            LOGGER.info("======================================================================================================\n\n");

            Context verificationChainContext1 = new ContextBase();
            Command verificationChain = chainYMLCatalog.getCommand(ChainNames.VERIFICATION_CHAIN.getChainName());
            verificationChain.execute(verificationChainContext1);

        } catch (Exception e) {
            LOGGER.error("{} ", e);
        }
    }


}
