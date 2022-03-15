package com.casadocodigo.shopapi.shopping.kafka;

import com.casadocodigo.shopapi.dto.ShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.casadocodigo.shopapi.configuration.kafka.KafkaTopics.SHOP_TOPIC;

@Service
@RequiredArgsConstructor
public class KafkaClient {

    private final KafkaTemplate<String, ShopDTO> kafkaTemplate;

    public void sendMessage(ShopDTO shopDTO){
        kafkaTemplate.send(SHOP_TOPIC.getName(), shopDTO);
    }
}
