package ar.com.plug.examen.application.controller;

import ar.com.plug.examen.application.dto.CustomerDto;
import ar.com.plug.examen.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ar.com.plug.examen.global.mapper.CustomerMapper.MAPPER;

@RestController
@RequestMapping(
        path = "/customer",
        produces = {MediaType.APPLICATION_JSON_VALUE },
        consumes = {MediaType.APPLICATION_JSON_VALUE }
)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> find(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MAPPER.toDto(
                                service.find(id)
                        )
                );
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CustomerDto customerDto) {
        service.create(
                MAPPER.toDomain(customerDto)
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

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        service.update(
                id,
                MAPPER.toDomain(customerDto)
        );

        return  ResponseEntity
                .ok()
                .build();
    }
}
