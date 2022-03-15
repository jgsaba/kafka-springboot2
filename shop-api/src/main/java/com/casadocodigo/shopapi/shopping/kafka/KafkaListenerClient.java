package com.casadocodigo.shopapi.shopping.kafka;

import com.casadocodigo.shopapi.dto.ShopDTO;
import com.casadocodigo.shopapi.shopping.ShopProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListenerClient {

    private final ObjectMapper objectMapper;
    private final ShopProcessor shopProcessor;


    @KafkaListener(topics = "SHOP_TOPIC_EVENT", groupId = "shop-event-consumer-group")
    public void kafkaListener(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        log.info("New shop event received. Record={}", consumerRecord);
        ShopDTO shopDTO = extractValue(consumerRecord);
        shopProcessor.processShop(shopDTO);
    }

    private ShopDTO extractValue(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        return objectMapper.readValue(consumerRecord.value(), ShopDTO.class);
    }
}
