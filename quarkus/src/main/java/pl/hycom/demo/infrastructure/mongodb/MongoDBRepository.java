package pl.hycom.demo.infrastructure.mongodb;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import pl.hycom.demo.domain.repository.DBRepository;
import pl.hycom.demo.domain.repository.User;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class MongoDBRepository implements DBRepository {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.persistOrUpdate(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().list();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userRepository.findById(new ObjectId(id)));
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(new ObjectId(id));
    }
}
