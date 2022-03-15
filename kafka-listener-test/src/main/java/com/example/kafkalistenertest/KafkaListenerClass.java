package com.example.kafkalistenertest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListenerClass {

    @KafkaListener(topics = "SHOP_TOPIC", groupId = "defa")
    public void listenShopTopic(ShopDTO shopDTO){
        log.info("{}", shopDTO);
    }
}
