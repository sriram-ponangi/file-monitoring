package com.file.monitoring.application;

import com.file.monitoring.application.events.MonitoringEventsLoader;
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

        } catch (Exception e) {
            LOGGER.error("{} ", e);
        }
    }


}
