package com.casadocodigo.shopreport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopEventListener {

    private final ShopEventService shopEventService;

    private final ObjectMapper objectMapper;

    @Transactional
    @KafkaListener(topics = "SHOP_TOPIC_EVENT", groupId = "shop-report-cg")
    public void shopEventListener(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        log.info("New event received. {}", consumerRecord);
        shopEventService.increaseReport(extractShop(consumerRecord).getStatus());
    }

    private ShopDTO extractShop(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        ShopDTO shopDTO = objectMapper.readValue(consumerRecord.value(), ShopDTO.class);
        log.info("Shop extracted from message = {}", shopDTO.toString());
        return shopDTO;
    }
}
