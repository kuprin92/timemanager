package com.company.timemanager.web.screens.timezoneoffset;

import com.haulmont.cuba.gui.screen.*;
import com.company.timemanager.entity.TimeZoneOffset;

@UiController("timemanager_TimeZoneOffset.edit")
@UiDescriptor("time-zone-offset-edit.xml")
@EditedEntityContainer("timeZoneOffsetDc")
@LoadDataBeforeShow
public class TimeZoneOffsetEdit extends StandardEditor<TimeZoneOffset> {
}