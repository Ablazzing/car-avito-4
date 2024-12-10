package com.javaacademy.car_avito_4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertDto {
    private UUID id;
    private String brand;
    private String color;
    private BigDecimal price;
}
