package pl.hycom.demo.infrastructure.mongodb;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pl.hycom.demo.domain.repository.User;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {
}
