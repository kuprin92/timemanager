package com.company.timemanager.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "TIMEMANAGER_TIME_ZONE_OFFSET")
@Entity(name = "timemanager_TimeZoneOffset")
@NamePattern("%s|name")
public class TimeZoneOffset extends StandardEntity {
    private static final long serialVersionUID = 1996034157437013300L;

    @NotNull(message = "{msg://timemanager_TimeZoneOffset.hour.validation.NotNull}")
    @Column(name = "HOUR_", nullable = false)
    @Min(message = "{msg://timemanager_TimeZoneOffset.hour.validation.Min}", value = 0)
    @Max(message = "{msg://timemanager_TimeZoneOffset.hour.validation.Max}", value = 12)
    private Integer hour;

    @NotNull(message = "{msg://timemanager_TimeZoneOffset.minute.validation.NotNull}")
    @Column(name = "MINUTE_", nullable = false)
    @Max(message = "{msg://timemanager_TimeZoneOffset.minute.validation.Max}", value = 59)
    @Min(message = "{msg://timemanager_TimeZoneOffset.minute.validation.Min}", value = 0)
    private Integer minute;

    @NotNull(message = "{msg://timemanager_TimeZoneOffset.second.validation.NotNull}")
    @Column(name = "SECOND_", nullable = false)
    @Max(message = "{msg://timemanager_TimeZoneOffset.second.validation.Max}", value = 59)
    @Min(message = "{msg://timemanager_TimeZoneOffset.second.validation.Min}", value = 0)
    private Integer second;

    @NotNull
    @Column(name = "OFFSET_TYPE", nullable = false)
    private String offsetType;

    @Column(name = "NAME", nullable = false, unique = true)
    @NotNull(message = "{msg://timemanager_TimeZoneOffset.name.validation.NotNull}")
    @Length(message = "{msg://timemanager_TimeZoneOffset.name.validation.NotNull}", min = 5)
    @CaseConversion
    private String name;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MetaProperty(related = {"hour", "minute", "offsetType", "second"})
    public Integer getGetOffset() {
        if (hour == null || minute == null || second == null || offsetType == null) return null;
        int offsetTypeValue = OffsetType.fromId(offsetType) == OffsetType.NEGATIVE ? -1 : 1;
        return (hour * 60 * 60 + minute * 60 + second) * offsetTypeValue;
    }

    public OffsetType getOffsetType() {
        return offsetType == null ? null : OffsetType.fromId(offsetType);
    }

    public void setOffsetType(OffsetType offsetType) {
        this.offsetType = offsetType == null ? null : offsetType.getId();
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}