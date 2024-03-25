package ar.com.plug.examen.domain.model;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private String lastName;
    private String email;
    private Integer age;
}
