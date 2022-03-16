package com.casadocodigo.shopapi.shopping.kafka;

import com.casadocodigo.shopapi.dto.ShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaClient {

    private final KafkaTemplate<String, ShopDTO> shopTopicDispatcher;

    public void sendMessage(ShopDTO shopDTO){
        shopTopicDispatcher.sendDefault(shopDTO.getBuyerIdentifier(), shopDTO);
    }
}
