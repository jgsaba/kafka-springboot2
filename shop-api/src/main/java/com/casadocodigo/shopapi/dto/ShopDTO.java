package com.casadocodigo.shopapi.dto;

import com.casadocodigo.shopapi.persistence.entity.Shop;
import com.casadocodigo.shopapi.shopping.ShopStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
public class ShopDTO {

    private	String identifier;

    private String buyerIdentifier;

    private	String status;

    private LocalDate dateShop;

    private List<ShopItemDTO> items;

    public static ShopDTO convert(Shop shop){
        return ShopDTO.builder()
                .identifier(shop.getIdentifier())
                .buyerIdentifier(shop.getBuyerIdentifier())
                .status(shop.getStatus().toString())
                .dateShop(shop.getDateShop())
                .items(shop.getItems()
                        .stream()
                        .map(ShopItemDTO::convert)
                        .collect(Collectors.toList()))
                .build();
    }

    public ShopDTO startUpNewShop(){
        this.setIdentifier(UUID.randomUUID().toString());
        this.setDateShop(LocalDate.now());
        this.setStatus(ShopStatus.PENDING.toString());

        return this;
    }
}
