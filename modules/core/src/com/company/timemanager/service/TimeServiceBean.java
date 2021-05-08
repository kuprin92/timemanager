package com.company.timemanager.service;

import com.company.timemanager.entity.TimeZoneOffset;
import com.company.timemanager.entity.ZoneEntry;
import com.haulmont.cuba.core.app.serialization.EntitySerializationAPI;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Configuration
@Service(TimeService.NAME)
public class TimeServiceBean implements TimeService {
    public static final String ZONE_ENTRY_UPDATE = "zone_entry_update";
    public static final String TIMEZONE_OFFSET_UPDATE = "timezone_offset_update";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Inject
    private EntitySerializationAPI entitySerializationAPI;

    @Bean
    public NewTopic zone_entry_update() {
        return TopicBuilder.name(ZONE_ENTRY_UPDATE).build();
    }

    @Bean
    public NewTopic timezone_offset_update() {
        return TopicBuilder.name(TIMEZONE_OFFSET_UPDATE).build();
    }

    @Override
    public void sendZoneEntry(ZoneEntry zoneEntry) {
        String data = entitySerializationAPI.toJson(zoneEntry);
        kafkaTemplate.send(ZONE_ENTRY_UPDATE, data);
    }

    @Override
    public void sendTimeZoneOffset(TimeZoneOffset offset) {
        String data = entitySerializationAPI.toJson(offset);
        kafkaTemplate.send(TIMEZONE_OFFSET_UPDATE, data);
    }
}