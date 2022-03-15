package com.casadocodigo.shopvalidator.shopvalidator.kafka;

import com.casadocodigo.shopvalidator.dto.ShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopEventKafkaDispatcher {

    private final KafkaTemplate<String, ShopDTO> kafkaTemplate;
    private final String SHOP_TOPIC_EVENT = "SHOP_TOPIC_EVENT";

    public void sendEvent(ShopDTO shopDTO){
        kafkaTemplate.send(SHOP_TOPIC_EVENT, shopDTO);
    }
}
