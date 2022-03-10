package com.casadocodigo.shopapi.persistence.entity;

import com.casadocodigo.shopapi.dto.ShopItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "shop_item")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_identifier")
    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public static ShopItem convert(ShopItemDTO shopItemDTO){
        ShopItem shopItem = new ShopItem();
        shopItem.setProductIdentifier(shopItemDTO.getProductIdentifier());
        shopItem.setPrice(shopItemDTO.getPrice());
        shopItem.setAmount(shopItemDTO.getAmount());

        return shopItem;
    }
}
