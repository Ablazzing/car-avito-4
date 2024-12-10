package com.javaacademy.car_avito_4.repository;

import com.javaacademy.car_avito_4.entity.Advert;
import com.javaacademy.car_avito_4.storage.AdvertStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AdvertRepository {
    private final AdvertStorage advertStorage;

    public void save(Advert advert) {
        Map<UUID, Advert> data = advertStorage.getData();
        if (advert.getId() != null && data.containsKey(advert.getId())) {
            throw new RuntimeException("Уже содержит такой ключ:%s".formatted(advert.getId()));
        }
        UUID id = UUID.randomUUID();
        advert.setId(id);
        data.put(id, advert);
    }

    public List<Advert> getAll() {
        return new ArrayList<>(advertStorage.getData().values());
    }

    public Optional<Advert> getById(UUID id) {
        return Optional.ofNullable(advertStorage.getData().get(id));
    }

    public boolean deleteById(UUID id) {
        return advertStorage.getData().remove(id) != null;
    }
}
