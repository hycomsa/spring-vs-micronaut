package pl.hycom.demo.infrastrucutre.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.hycom.demo.domain.repository.User;

public interface UserRepository extends MongoRepository<User, String> {
}
