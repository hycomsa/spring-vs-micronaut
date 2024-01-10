package pl.hycom.demo.application;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Data;

@Data
public class UserDto extends PanacheMongoEntity {
    private String firstName;
    private String lastName;
}
