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
    NAME varchar(255),
    DESCRIPTION text,
    --
    primary key (ID)
);