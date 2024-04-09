package ar.com.plug.examen.application.controller;


import ar.com.plug.examen.application.dto.in.CreateOrderDto;
import ar.com.plug.examen.application.dto.out.FindOrderDto;
import ar.com.plug.examen.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ar.com.plug.examen.global.mapper.OrderMapper.MAPPER;

@RestController
@RequestMapping(
        path = "/order",
        produces = {MediaType.APPLICATION_JSON_VALUE },
        consumes = {MediaType.APPLICATION_JSON_VALUE }
)
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService service;

    @GetMapping("/{id}")
    ResponseEntity<FindOrderDto> find(@PathVariable Long id) {
        FindOrderDto f = MAPPER.toDto(service.find(id));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(f);
    }

    @PostMapping
    ResponseEntity<Void> create(@Valid @RequestBody CreateOrderDto orderDto) {
        service.create(
                MAPPER.toDomain(orderDto)
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity
                .ok()
                .build();
    }

    @PatchMapping("/authorize/{id}")
    ResponseEntity<Void> authorize(@PathVariable Long id) {
        service.authorize(id);

        return ResponseEntity
                .ok()
                .build();
    }
}
