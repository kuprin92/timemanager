package com.company.timemanager.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "TIMEMANAGER_ZONE_ENTRY")
@Entity(name = "timemanager_ZoneEntry")
@NamePattern("%s|name")
public class ZoneEntry extends StandardEntity {
    private static final long serialVersionUID = 2483331920707713144L;

    @CaseConversion
    @NotNull(message = "{msg://timemanager_ZoneEntry.name.validation.NotNull}")
    @Column(name = "NAME", nullable = false, unique = true)
    @Length(message = "{msg://timemanager_ZoneEntry.name.validation.NotNull}", min = 5)
    private String name;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open", "clear"})
    @NotNull(message = "{msg://timemanager_ZoneEntry.zoneOffset.validation.NotNull}")
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZONE_OFFSET_ID")
    private TimeZoneOffset zoneOffset;

    public TimeZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(TimeZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}