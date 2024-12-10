package com.javaacademy.car_avito_4.service;

import com.javaacademy.car_avito_4.dto.AdvertDto;
import com.javaacademy.car_avito_4.dto.CreateAdvertDto;
import com.javaacademy.car_avito_4.entity.Advert;
import com.javaacademy.car_avito_4.mapper.AdvertMapper;
import com.javaacademy.car_avito_4.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertMapper advertMapper;

    public void save(CreateAdvertDto dto) {
        advertRepository.save(advertMapper.convertToEntity(dto));
    }

    public List<AdvertDto> getByParams(String brand, String color, String price) {
        return advertRepository.getAll().stream()
                .filter(advert -> filterAdvert(advert, brand, color, price))
                .map(advertMapper::convertToDto)
                .toList();
    }

    private boolean filterAdvert(Advert advert, String brand, String color, String price) {
        Predicate<Advert> filter = e -> true;
        filter = createStringPredicate(filter, brand, advert.getBrand());
        filter = createStringPredicate(filter, color, advert.getColor());

        if (price != null) {
            if ("null".equals(price)) {
                filter = filter.and(e -> e.getPrice() == null);
            } else {
                BigDecimal priceBigDecimal = new BigDecimal(price);
                filter = filter.and(e -> e.getPrice() != null && e.getPrice().compareTo(priceBigDecimal) == 0);
            }
        }

        return filter.test(advert);
    }


    private Predicate<Advert> createStringPredicate(Predicate<Advert> beforeFilter, String paramValue, String entityValue) {
        if (paramValue == null) {
            return beforeFilter;
        }
        if (paramValue.equals("null")) {
            return beforeFilter.and(e -> entityValue == null);
        }
        return beforeFilter.and(e -> Objects.equals(paramValue, entityValue));
    }


    public AdvertDto getById(UUID id) {
        return advertRepository.getById(id).map(advertMapper::convertToDto).orElseThrow();
    }

    public boolean deleteById(UUID id) {
        return advertRepository.deleteById(id);
    }

}
