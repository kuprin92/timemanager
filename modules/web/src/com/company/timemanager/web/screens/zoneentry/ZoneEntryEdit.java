package com.company.timemanager.web.screens.zoneentry;

import com.haulmont.cuba.gui.screen.*;
import com.company.timemanager.entity.ZoneEntry;

@UiController("timemanager_ZoneEntry.edit")
@UiDescriptor("zone-entry-edit.xml")
@EditedEntityContainer("zoneEntryDc")
@LoadDataBeforeShow
public class ZoneEntryEdit extends StandardEditor<ZoneEntry> {
}