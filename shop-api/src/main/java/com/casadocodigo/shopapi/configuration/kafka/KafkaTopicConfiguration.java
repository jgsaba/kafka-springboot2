package com.casadocodigo.shopapi.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.casadocodigo.shopapi.configuration.kafka.KafkaTopics.SHOP_TOPIC;
import static com.casadocodigo.shopapi.configuration.kafka.KafkaTopics.SHOP_TOPIC_EVENT;

@Configuration
public class KafkaTopicConfiguration {

    @Bean(name = "shopTopic")
    public NewTopic shopTopic(){
        return TopicBuilder.name(SHOP_TOPIC.getName())
                .partitions(SHOP_TOPIC.getPartitions())
                .replicas(SHOP_TOPIC.getReplicationFactor())
                .build();
    }

    @Bean(name = "shopEventTopic")
    public NewTopic shopEventTopic(){
        return TopicBuilder.name(SHOP_TOPIC_EVENT.getName())
                .partitions(SHOP_TOPIC_EVENT.getPartitions())
                .replicas(SHOP_TOPIC_EVENT.getReplicationFactor())
                .build();
    }
}
