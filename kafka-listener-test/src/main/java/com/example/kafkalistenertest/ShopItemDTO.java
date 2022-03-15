package com.example.kafkalistenertest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopItemDTO {

    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;
}
