-- update TIMEMANAGER_TIME_ZONE_OFFSET set NAME = <default_value> where NAME is null ;
alter table TIMEMANAGER_TIME_ZONE_OFFSET alter column NAME set not null ;
