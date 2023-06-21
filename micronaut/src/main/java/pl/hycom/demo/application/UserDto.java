package pl.hycom.demo.application;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
}
