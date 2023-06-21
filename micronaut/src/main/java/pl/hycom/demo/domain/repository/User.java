package pl.hycom.demo.domain.repository;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

@MappedEntity
@Data
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
}
