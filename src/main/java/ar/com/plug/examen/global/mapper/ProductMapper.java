package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.ProductDto;
import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product toDomain(ProductDto product);

    Product toDomain(ProductEntity product);

    ProductEntity toEntity(Product product);
}
