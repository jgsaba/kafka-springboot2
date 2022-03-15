package com.casadocodigo.shopvalidator.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShopItemDTO {

    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;
}
