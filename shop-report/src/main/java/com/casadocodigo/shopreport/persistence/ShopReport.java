package com.casadocodigo.shopreport.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "shop_report", schema = "report")
public class ShopReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Integer quantity;

    public void increaseQuantity(){
        this.quantity ++;
    }
}
