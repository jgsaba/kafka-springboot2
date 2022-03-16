package com.casadocodigo.shopreport.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServerAddress;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

        return concurrentKafkaListenerContainerFactory;
    }

    private ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress));
    }
}
