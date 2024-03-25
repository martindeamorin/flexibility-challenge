package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.CustomerDto;
import ar.com.plug.examen.domain.model.Customer;
import ar.com.plug.examen.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(Customer customer);

    Customer toDomain(CustomerDto customer);

    Customer toDomain(CustomerEntity customer);

    CustomerEntity toEntity(Customer customer);

    void toUpdatedEntity(Customer customer, @MappingTarget CustomerEntity customerEntity);
}
