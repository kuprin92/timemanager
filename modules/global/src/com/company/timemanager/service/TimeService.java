package com.company.timemanager.service;

import com.company.timemanager.entity.TimeZoneOffset;
import com.company.timemanager.entity.ZoneEntry;

public interface TimeService {
    String NAME = "timemanager_TimeService";

    void sendZoneEntry(ZoneEntry zoneEntry);

    void sendTimeZoneOffset(TimeZoneOffset offset);
}