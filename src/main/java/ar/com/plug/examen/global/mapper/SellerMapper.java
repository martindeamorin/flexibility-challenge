package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.SellerDto;
import ar.com.plug.examen.domain.model.Seller;
import ar.com.plug.examen.infrastructure.entity.SellerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SellerMapper {
    SellerMapper MAPPER = Mappers.getMapper(SellerMapper.class);

    SellerDto toDto(Seller customer);

    Seller toDomain(SellerDto customer);

    Seller toDomain(SellerEntity customer);

    SellerEntity toEntity(Seller customer);

    void toUpdatedEntity(Seller customer, @MappingTarget SellerEntity sellerEntity);
}
