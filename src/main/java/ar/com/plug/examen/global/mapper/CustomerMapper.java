package ar.com.plug.examen.global.mapper;

import ar.com.plug.examen.application.dto.in.CreateCustomerDto;
import ar.com.plug.examen.application.dto.in.UpdateCustomerDto;
import ar.com.plug.examen.application.dto.out.FindCustomerDto;
import ar.com.plug.examen.domain.model.Customer;
import ar.com.plug.examen.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    FindCustomerDto toDto(Customer customer);

    @Mapping(target = "name", expression = "java(customer.getName().toUpperCase())")
    @Mapping(target = "lastName", expression = "java(customer.getLastName().toUpperCase())")
    Customer toDomain(CreateCustomerDto customer);

    @Mapping(target = "name", expression = "java(customer.getName().toUpperCase())")
    @Mapping(target = "lastName", expression = "java(customer.getLastName().toUpperCase())")
    @Mapping(target = "email", ignore = true)
    Customer toDomain(UpdateCustomerDto customer);

    Customer toDomain(CustomerEntity customer);

    CustomerEntity toEntity(Customer customer);

    void toUpdatedEntity(Customer customer, @MappingTarget CustomerEntity customerEntity);
}
