package com.javaacademy.car_avito_4.storage;

import com.javaacademy.car_avito_4.entity.Advert;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class AdvertStorage {
    @Getter
    private final Map<UUID, Advert> data = new HashMap<>();
}
