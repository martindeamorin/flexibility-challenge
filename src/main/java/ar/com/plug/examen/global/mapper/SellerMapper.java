package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.in.CreateSellerDto;
import ar.com.plug.examen.application.dto.in.UpdateSellerDto;
import ar.com.plug.examen.application.dto.out.FindSellerDto;
import ar.com.plug.examen.domain.model.Seller;
import ar.com.plug.examen.infrastructure.entity.SellerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SellerMapper {
    SellerMapper MAPPER = Mappers.getMapper(SellerMapper.class);

    FindSellerDto toDto(Seller seller);

    @Mapping(target = "name", expression = "java(seller.getName().toUpperCase())")
    @Mapping(target = "lastName", expression = "java(seller.getLastName().toUpperCase())")
    @Mapping(target = "businessName", expression = "java(seller.getBusinessName().toUpperCase())")
    @Mapping(target = "id", ignore = true)
    Seller toDomain(CreateSellerDto seller);
    
    @Mapping(target = "name", expression = "java(seller.getName().toUpperCase())")
    @Mapping(target = "lastName", expression = "java(seller.getLastName().toUpperCase())")
    @Mapping(target = "businessName", ignore = true)
    @Mapping(target = "id", ignore = true)
    Seller toDomain(UpdateSellerDto seller);

    Seller toDomain(SellerEntity seller);

    SellerEntity toEntity(Seller seller);

    void toUpdatedEntity(Seller seller, @MappingTarget SellerEntity sellerEntity);
}
