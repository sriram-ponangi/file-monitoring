package com.file.monitoring.application.events.listeners;

import com.file.monitoring.application.events.config.beans.EventConfig;
import com.file.monitoring.application.events.config.beans.EventInfo;
import com.file.monitoring.application.events.constants.MonitoringEventType;
import com.file.monitoring.catalog.constants.ChainNames;
import com.file.monitoring.common.configs.Catalog;
import com.file.monitoring.common.configs.Chain;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

@Component("MonitoringEventListener")
public class MonitoringEventListener extends FileAlterationListenerAdaptor {

    @Autowired
    @Qualifier("ChainCatalog")
    protected Catalog chainCatalog;

    @Autowired
    @Qualifier("ActiveMonitoringEventConfigsMap")
    protected HashMap<String, EventConfig> activeEventsMap;

    protected final void executeMonitoringEvent(File file, MonitoringEventType eventType){
        Optional<EventInfo> optionalEventInfo = getValidEventInfo(file.getParent(), eventType);
        optionalEventInfo.ifPresent(this::executeChain);
    }

    private final void executeChain(EventInfo eventInfo){

        if(eventInfo== null || ChainNames.valueOf(eventInfo.getChainInfo().getName()) == null){
            return;
        }

        HashMap<String, Object> chainContext = new HashMap<>();
        eventInfo.getChainInfo().getContextParams().forEach(param -> {
            chainContext.put(param.getKey(), param.getValue());
        });

        try {
            Chain chain = chainCatalog.getChain(eventInfo.getChainInfo().getName());
            chain.execute(chainContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Optional<EventInfo> getValidEventInfo(String monitoringPath, MonitoringEventType eventType){
        EventConfig eventConfig = activeEventsMap.get(monitoringPath);
        if(eventConfig == null){
            return Optional.empty();
        }

        Optional<EventInfo> eventInfo = eventConfig.getEventsInfo().stream()
                .filter(event -> event.getType().equals(eventType))
                .filter(EventInfo::isActive)
                .findFirst();

        return eventInfo;
    }

    @Override
    public void onFileChange(File file) {
        executeMonitoringEvent(file, MonitoringEventType.FILE_CHANGE);
    }

    @Override
    public void onFileCreate(File file) {
        executeMonitoringEvent(file, MonitoringEventType.FILE_CREATE);
    }

    @Override
    public void onFileDelete(File file) {
        executeMonitoringEvent(file, MonitoringEventType.FILE_DELETE);
    }

}
