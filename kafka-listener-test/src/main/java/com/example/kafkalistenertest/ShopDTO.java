package com.example.kafkalistenertest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopDTO {

    private	String identifier;

    private	String status;

    private LocalDate dateShop;

    private List<ShopItemDTO> items;

}
