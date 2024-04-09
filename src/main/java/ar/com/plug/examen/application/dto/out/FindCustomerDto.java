package ar.com.plug.examen.application.dto.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindCustomerDto {
    private String name;
    private String lastName;
    private String email;
    private Integer age;
}
