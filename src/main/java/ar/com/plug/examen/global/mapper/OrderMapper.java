package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.in.CreateOrderDto;
import ar.com.plug.examen.application.dto.out.FindOrderDto;
import ar.com.plug.examen.domain.model.Order;
import ar.com.plug.examen.infrastructure.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    FindOrderDto toDto(Order order);

    @Mapping(target = "customer.id", source = "customerId" )
    Order toDomain(CreateOrderDto order);
    Order toDomain(OrderEntity order);

    @Mapping(target = "isAuthorized", defaultValue = "false")
    OrderEntity toEntity(Order order);
}
