package com.company.timemanager.listeners;

import com.company.timemanager.entity.TimeZoneOffset;
import com.company.timemanager.service.TimeService;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("timemanager_TimeZoneOffsetChangedListener")
public class TimeZoneOffsetChangedListener {

    @Inject
    private DataManager dataManager;
    @Inject
    private TimeService timeService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<TimeZoneOffset, UUID> event) {
        TimeZoneOffset timeZoneOffset = dataManager.load(event.getEntityId()).view(View.LOCAL).one();
        timeService.sendTimeZoneOffset(timeZoneOffset);
    }
}