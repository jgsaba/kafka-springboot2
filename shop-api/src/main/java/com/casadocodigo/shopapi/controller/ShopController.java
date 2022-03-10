package com.casadocodigo.shopapi.controller;

import com.casadocodigo.shopapi.dto.ShopDTO;
import com.casadocodigo.shopapi.persistence.entity.Shop;
import com.casadocodigo.shopapi.persistence.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopRepository shopRepository;

    @GetMapping
    public List<ShopDTO> getShop(){
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ShopDTO saveShop(@RequestBody ShopDTO shopDTO){
        Shop newShop = Shop.convert(shopDTO.startUpNewShop());
        return ShopDTO.convert(shopRepository.save(newShop));
    }
}
