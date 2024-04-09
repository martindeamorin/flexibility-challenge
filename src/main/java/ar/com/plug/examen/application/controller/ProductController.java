package ar.com.plug.examen.application.controller;

import ar.com.plug.examen.application.dto.in.CreateProductDto;
import ar.com.plug.examen.application.dto.in.UpdateProductDto;
import ar.com.plug.examen.application.dto.out.FindProductDto;
import ar.com.plug.examen.domain.service.ProductService;
import static ar.com.plug.examen.global.mapper.ProductMapper.MAPPER;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(
        path = "/product",
        produces = {MediaType.APPLICATION_JSON_VALUE },
        consumes = {MediaType.APPLICATION_JSON_VALUE }
)
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService service;
    @GetMapping("/{id}")
    ResponseEntity<FindProductDto> find(@PathVariable Long id) {
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(MAPPER.toDto(
                            service.find(id)
                    )
        );
    }

    @PostMapping
    ResponseEntity<Void> create(@Valid @RequestBody CreateProductDto productDto) {
        service.create(
                MAPPER.toDomain(productDto)
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
    ResponseEntity<Void> update(@PathVariable Long id, @Valid @NotNull @RequestBody UpdateProductDto productDto){
        service.update(
                id,
                MAPPER.toDomain(productDto)
        );

        return  ResponseEntity
                .ok()
                .build();
    }

}
