package com.company.timemanager.listeners;

import com.company.timemanager.entity.ZoneEntry;
import com.company.timemanager.service.TimeService;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("timemanager_ZoneEntryChangedListener")
public class ZoneEntryChangedListener {

    @Inject
    private DataManager dataManager;
    @Inject
    private TimeService timeService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<ZoneEntry, UUID> event) {
        ZoneEntry zoneEntry = dataManager.load(event.getEntityId()).view("zoneEntry-full")
                .one();
        timeService.sendZoneEntry(zoneEntry);
    }
}