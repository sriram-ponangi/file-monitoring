package com.file.monitoring.application;

import com.file.monitoring.application.io.MonitoringEventsLoader;
import com.file.monitoring.application.io.config.beans.MonitoringConfigsBean;
import org.apache.commons.chain.Catalog;
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

//    @Autowired
//    @Qualifier("ChainCatalog")
//    private Catalog chainCatalog;
//
//    @Autowired
//    @Qualifier("MonitoringConfigs")
//    private MonitoringConfigsBean monitoringConfigs;

    @Autowired
    @Qualifier("MonitoringEventsLoader")
    private MonitoringEventsLoader monitoringEventsLoader;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(FileMonitoringApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            monitoringEventsLoader.loadMonitoringEvents();
            LOGGER.info("Registered Event Monitors = {} ", MonitoringEventsLoader.REGISTERED_EVENT_MONITORS);
//
//            LOGGER.info("chainYMLCatalog = {} ", chainCatalog);
//            LOGGER.info("monitoringConfigs = {} ", monitoringConfigs);


/*
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
*/
        } catch (Exception e) {
            LOGGER.error("{} ", e);
        }
    }


}
