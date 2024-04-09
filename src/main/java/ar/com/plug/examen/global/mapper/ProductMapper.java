package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.in.CreateProductDto;
import ar.com.plug.examen.application.dto.in.UpdateProductDto;
import ar.com.plug.examen.application.dto.out.FindProductDto;
import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.model.ProductSnapshot;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE
)
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    FindProductDto toDto(Product product);

    @Mapping(target = "name", expression = "java(product.getName().toUpperCase())")
    @Mapping(target = "seller.id", source = "sellerId")
    Product toDomain(CreateProductDto product);

    @Mapping(target = "name", expression = "java(product.getName().toUpperCase())")
    @Mapping(target = "seller", ignore = true)
    Product toDomain(UpdateProductDto product);

    default void toDomain(@MappingTarget List<ProductSnapshot> productSnapshots, List<Product> products){
        if (products == null) {
            return;
        }

        for (Product product: products) {
            ProductSnapshot productSnapshot = productSnapshots
                    .stream()
                    .filter(ps -> ps.getProductId().equals(product.getId()))
                    .findFirst()
                    .orElse(null);
            productToUpdateProductSnapshot(product, productSnapshot);
        }
    }

    default void productToUpdateProductSnapshot(Product product, ProductSnapshot productSnapshot) {
        if ( product == null ) {
            return;
        }

        productSnapshot.setName( product.getName() );
        productSnapshot.setDescription( product.getDescription() );
        productSnapshot.setPrice( product.getPrice() );
    }

    Product toDomain(ProductEntity product);

    ProductEntity toEntity(Product product);

    void toUpdatedEntity(@MappingTarget ProductEntity productEntity, Product product);

    List<Product> toDomain(List<ProductEntity> products);
}
