package ar.com.plug.examen.application.controller;

import ar.com.plug.examen.application.dto.SellerDto;
import ar.com.plug.examen.domain.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ar.com.plug.examen.global.mapper.SellerMapper.MAPPER;

@RestController
@RequestMapping(
        path = "/seller",
        produces = {MediaType.APPLICATION_JSON_VALUE },
        consumes = {MediaType.APPLICATION_JSON_VALUE }
)
@RequiredArgsConstructor
@Slf4j
public class SellerController {
    private final SellerService service;
    @GetMapping("/{id}")
    ResponseEntity<SellerDto> find(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MAPPER.toDto(
                                service.find(id)
                        )
                );
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody SellerDto sellerDto) {
        service.create(
                MAPPER.toDomain(sellerDto)
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
    ResponseEntity<Void> update(@PathVariable Long id, @RequestBody SellerDto sellerDto){
        service.update(
                id,
                MAPPER.toDomain(sellerDto)
        );

        return  ResponseEntity
                .ok()
                .build();
    }

}
