package com.casadocodigo.shopvalidator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
