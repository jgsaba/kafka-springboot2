package com.casadocodigo.shopapi.dto;

import com.casadocodigo.shopapi.persistence.entity.ShopItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShopItemDTO {

    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;

    public static ShopItemDTO convert(ShopItem shopItem){
        return ShopItemDTO.builder()
                .productIdentifier(shopItem.getProductIdentifier())
                .amount(shopItem.getAmount())
                .price(shopItem.getPrice())
                .build();
    }
}
