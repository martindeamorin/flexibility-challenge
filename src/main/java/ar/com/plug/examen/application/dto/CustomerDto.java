package ar.com.plug.examen.application.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String lastName;
    private String email;
    private Integer age;
}
