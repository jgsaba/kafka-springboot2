package com.casadocodigo.shopapi.configuration.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KafkaTopics {

    SHOP_TOPIC("SHOP_TOPIC", 6, 1),
    SHOP_TOPIC_EVENT("SHOP_TOPIC_EVENT", 3, 1);

    private final String name;
    private final Integer partitions;
    private final Integer replicationFactor;
}
