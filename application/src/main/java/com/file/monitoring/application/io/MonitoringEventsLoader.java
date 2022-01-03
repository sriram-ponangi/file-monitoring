package com.file.monitoring.application.io;

import com.file.monitoring.application.io.config.beans.EventConfig;
import com.file.monitoring.application.io.config.beans.MonitoringConfigsBean;
import com.file.monitoring.application.io.listeners.MonitoringEventListener;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component("MonitoringEventsLoader")
public class MonitoringEventsLoader {

    public static final ConcurrentHashMap<String, FileAlterationMonitor> REGISTERED_EVENT_MONITORS =
            new ConcurrentHashMap();

    @Autowired
    @Qualifier("MonitoringConfigs")
    private MonitoringConfigsBean monitoringConfigsBean;

    @Autowired
    @Qualifier("MonitoringEventListener")
    MonitoringEventListener monitoringEventListener;

    public void loadMonitoringEvents() {
        monitoringConfigsBean.getMonitoringEvents()
                .stream().filter(EventConfig::isActive).forEach(eventConfig -> {

                    FileAlterationObserver observer = new FileAlterationObserver(eventConfig.getPath());
                    // TODO: Take poll interval in YAML
                    FileAlterationMonitor monitor = new FileAlterationMonitor(5000);
                    FileAlterationListener fal = new FileAlterationListenerAdaptor();
                    // TODO NOTE: - 1 (SEE BELOW COMMENT FOR MORE DETAILS)

                    final String MONITOR_EVENT_KEY = eventConfig.getName();
                    if(REGISTERED_EVENT_MONITORS.containsKey(MONITOR_EVENT_KEY)){
                        try {
                            REGISTERED_EVENT_MONITORS.get(MONITOR_EVENT_KEY).stop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    REGISTERED_EVENT_MONITORS.put(MONITOR_EVENT_KEY, monitor);

                    observer.addListener(monitoringEventListener);
                    monitor.addObserver(observer);
                    try {
                        monitor.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
    }
}




/* TODO NOTE: - 1
    * No need to create a new FileAlterationListener object and FileAlterationMonitor object
    * for every event( FILE_CREATE, FILE_CHANGE, etc.).
    *
    * One monitor is enough for one directory / path. Which can have a FileAlterationListener with
    * multiple methods overloaded.

    eventConfig.getEventsInfo().stream().filter(EventInfo::isActive).forEach(eventInfo -> {
        if (MonitoringEventType.FILE_CREATE == eventInfo.getType()) {
            fal = new FileCreateEventListener();
        } else if (MonitoringEventType.FILE_CHANGE == eventInfo.getType()) {
            fal = new FileChangeEventListener();
        } else if (MonitoringEventType.FILE_DELETE == eventInfo.getType()) {
            fal = new FileDeleteEventListener();
        }else {
            return;
        }

    });

*/