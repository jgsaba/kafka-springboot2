package com.casadocodigo.shopreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopDTO {
    private	String identifier;
    private	String status;
}
