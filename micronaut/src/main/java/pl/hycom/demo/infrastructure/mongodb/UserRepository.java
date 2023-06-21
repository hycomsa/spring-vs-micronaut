package pl.hycom.demo.infrastructure.mongodb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import pl.hycom.demo.domain.repository.User;

@MongoRepository(databaseName = "user")
public interface UserRepository extends CrudRepository<User, String> {
}
