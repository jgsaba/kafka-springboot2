package com.casadocodigo.shopapi.controller;

import com.casadocodigo.shopapi.dto.ShopDTO;
import com.casadocodigo.shopapi.persistence.entity.Shop;
import com.casadocodigo.shopapi.persistence.repository.ShopRepository;
import com.casadocodigo.shopapi.shopping.kafka.KafkaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopRepository shopRepository;

    private final KafkaClient kafkaClient;

    @GetMapping
    public List<ShopDTO> getShop(){
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ShopDTO saveShop(@RequestBody ShopDTO shopDTO){
        Shop newShop = shopRepository.save(Shop.convert(shopDTO.startUpNewShop()));
        ShopDTO newShopDTO = ShopDTO.convert(newShop);
        kafkaClient.sendMessage(newShopDTO);

        return newShopDTO;
    }
}
