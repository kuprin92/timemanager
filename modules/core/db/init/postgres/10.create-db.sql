-- begin TIMEMANAGER_TIME_ZONE_OFFSET
create table TIMEMANAGER_TIME_ZONE_OFFSET (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    HOUR_ integer not null,
    MINUTE_ integer not null,
    SECOND_ integer not null,
    OFFSET_TYPE varchar(50) not null,
    NAME varchar(255) not null,
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end TIMEMANAGER_TIME_ZONE_OFFSET
-- begin TIMEMANAGER_ZONE_ENTRY
create table TIMEMANAGER_ZONE_ENTRY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ZONE_OFFSET_ID uuid not null,
    --
    primary key (ID)
)^
-- end TIMEMANAGER_ZONE_ENTRY
