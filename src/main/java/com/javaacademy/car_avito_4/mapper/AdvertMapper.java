package com.javaacademy.car_avito_4.mapper;

import com.javaacademy.car_avito_4.dto.AdvertDto;
import com.javaacademy.car_avito_4.dto.CreateAdvertDto;
import com.javaacademy.car_avito_4.entity.Advert;
import org.springframework.stereotype.Component;

@Component
public class AdvertMapper {

    public Advert convertToEntity(CreateAdvertDto dto) {
        return new Advert(dto.getBrand(), dto.getColor(), dto.getPrice());
    }

    public AdvertDto convertToDto(Advert entity) {
        return new AdvertDto(entity.getId(), entity.getBrand(), entity.getColor(), entity.getPrice());
    }
}
