package com.company.timemanager.web.screens.zoneentry;

import com.company.timemanager.entity.TimeZoneOffset;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.timemanager.entity.ZoneEntry;

import java.time.ZoneOffset;

@UiController("timemanager_ZoneEntry.browse")
@UiDescriptor("zone-entry-browse.xml")
@LookupComponent("zoneEntriesTable")
@LoadDataBeforeShow
public class ZoneEntryBrowse extends StandardLookup<ZoneEntry> {
    public Component getOffset(ZoneEntry entity) {
        Integer offset = entity.getZoneOffset().getGetOffset();
        return new Table.PlainTextCell(ZoneOffset.ofTotalSeconds(offset).getId());
    }
}