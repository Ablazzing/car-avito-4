package com.javaacademy.car_avito_4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Advert {
    private UUID id;
    private String brand;
    private String color;
    private BigDecimal price;

    public Advert(String brand, String color, BigDecimal price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
