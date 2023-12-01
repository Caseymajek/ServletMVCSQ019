package com.decagon.servletmvcsq019.model;

import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String category;
    private Long quantity;
    @Getter
    private BigDecimal productPrice;


    public Product(String name, String category, Long quantity, BigDecimal productPrice) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

}
