package com.casadocodigo.shopvalidator.shopvalidator.kafka;

import com.casadocodigo.shopvalidator.dto.ShopDTO;
import com.casadocodigo.shopvalidator.shopvalidator.ValidatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShopTopicKafkaListener {

    private final String SHOP_TOPIC_NAME = "SHOP_TOPIC";

    private final ValidatorService validatorService;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = SHOP_TOPIC_NAME, groupId = "shop-topic-consumer-group")
    public void listenShopTopic(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        log.info(consumerRecord.toString());
        ShopDTO shopDTO = extractPayload(consumerRecord);
        log.info("Compra recebida no tópico: {}", shopDTO.getIdentifier());
        validatorService.validateShop(shopDTO);
    }

    private ShopDTO extractPayload(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        return objectMapper.readValue(consumerRecord.value(), ShopDTO.class);
    }
}
