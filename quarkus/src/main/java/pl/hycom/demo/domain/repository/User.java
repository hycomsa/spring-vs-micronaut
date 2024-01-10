package pl.hycom.demo.domain.repository;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class User {
    private ObjectId id;
    private String firstName;
    private String lastName;
}
