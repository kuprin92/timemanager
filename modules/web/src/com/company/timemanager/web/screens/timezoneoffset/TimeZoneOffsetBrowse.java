package com.company.timemanager.web.screens.timezoneoffset;

import com.company.timemanager.entity.TimeZoneOffset;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@UiController("timemanager_TimeZoneOffset.browse")
@UiDescriptor("time-zone-offset-browse.xml")
@LookupComponent("timeZoneOffsetsTable")
@LoadDataBeforeShow
public class TimeZoneOffsetBrowse extends StandardLookup<TimeZoneOffset> {
    @Inject
    private TimeSource timeSource;

    public Component currentTime(TimeZoneOffset entity) {
        ZonedDateTime now = timeSource.now();
        return new Table.PlainTextCell(now.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }

    public Component time(TimeZoneOffset entity) {
        Integer offset = entity.getGetOffset();
        return new Table.PlainTextCell(ZonedDateTime.now(ZoneOffset.ofTotalSeconds(offset)).toLocalDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }

    public Component currentOffset(TimeZoneOffset entity) {
        ZonedDateTime now = timeSource.now();
        return new Table.PlainTextCell(now.getOffset().getId());
    }

    public Component getOffset(TimeZoneOffset entity) {
        Integer offset = entity.getGetOffset();
        return new Table.PlainTextCell(ZoneOffset.ofTotalSeconds(offset).getId());
    }

    public Component currentUTC(TimeZoneOffset entity) {
        return new Table.PlainTextCell(ZonedDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }
}