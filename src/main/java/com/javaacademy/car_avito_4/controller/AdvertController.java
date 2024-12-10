package com.javaacademy.car_avito_4.controller;

import com.javaacademy.car_avito_4.dto.AdvertDto;
import com.javaacademy.car_avito_4.dto.CreateAdvertDto;
import com.javaacademy.car_avito_4.service.AdvertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
@Slf4j
public class AdvertController {
    private final AdvertService advertService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public void save(@RequestBody CreateAdvertDto dto) {
        advertService.save(dto);
    }

    @GetMapping
    public List<AdvertDto> getAll(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String price
    ) {
        log.info("brand param: {} , color param: {}, price param {}", brand, color, price);
        log.info("brand is null? or is text? {}", brand == null);
        return advertService.getByParams(brand, color, price);
    }

    @GetMapping("/{id}")
    public AdvertDto getById(@PathVariable UUID id) {
        return advertService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable UUID id) {
        return advertService.deleteById(id);
    }

}
