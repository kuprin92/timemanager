package com.company.timemanager.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum OffsetType implements EnumClass<String> {

    POSITIVE("positive"),
    NEGATIVE("negative");

    private final String id;

    OffsetType(String value) {
        this.id = value;
    }

    @Nullable
    public static OffsetType fromId(String id) {
        for (OffsetType at : OffsetType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }
}