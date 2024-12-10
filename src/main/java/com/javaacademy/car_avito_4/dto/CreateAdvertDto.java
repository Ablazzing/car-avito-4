package com.javaacademy.car_avito_4.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAdvertDto {
    private String brand;
    private String color;
    private BigDecimal price;
}
