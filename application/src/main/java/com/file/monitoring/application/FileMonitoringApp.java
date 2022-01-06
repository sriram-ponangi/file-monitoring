package com.file.monitoring.application;

import com.file.monitoring.application.events.MonitoringEventsLoader;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

@SpringBootApplication(scanBasePackages = {"com.file.monitoring"})
@EnableEncryptableProperties
public class FileMonitoringApp implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileMonitoringApp.class);

    @Autowired
    @Qualifier("MonitoringEventsLoader")
    private MonitoringEventsLoader monitoringEventsLoader;

    public static void main(String[] args) {

        SpringApplication.run(FileMonitoringApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            monitoringEventsLoader.loadMonitoringEvents();
            LOGGER.info("Registered Event Monitors = {} ", MonitoringEventsLoader.REGISTERED_EVENT_MONITORS);

        } catch (Exception e) {
            LOGGER.error("Application Could Not be Started Properly. {} ", ExceptionUtils.getRootCauseMessage(e));
        }
    }
    
    @PreDestroy
    public void onExit() {
        LOGGER.info("STOPPING THE ACTIVE FILE MONITORS. TOTAL ACTIVE FILE MONITORS = {} ", MonitoringEventsLoader.REGISTERED_EVENT_MONITORS.size());
        try {

            MonitoringEventsLoader.REGISTERED_EVENT_MONITORS.forEach((key, fileAlterationMonitor) -> {
                try {
                    LOGGER.info("Stopping File Monitor = {} ", key);
                    fileAlterationMonitor.stop();
                } catch (Exception e) {
                    LOGGER.error("Failed To Stop File Monitor For {} With Error: {} ", key, ExceptionUtils.getRootCauseMessage(e));
                }
            });
        } catch (Exception e) {
            LOGGER.error("Application Shutdown Unsuccessful. {} ", ExceptionUtils.getRootCauseMessage(e));
        }
        LOGGER.info("ALL ACTIVE FILE MONITORS HAVE BEEN STOPPED.");
    }


}
