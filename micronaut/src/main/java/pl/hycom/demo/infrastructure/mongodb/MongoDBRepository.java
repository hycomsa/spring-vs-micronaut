package pl.hycom.demo.infrastructure.mongodb;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import pl.hycom.demo.domain.repository.DBRepository;
import pl.hycom.demo.domain.repository.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
@RequiredArgsConstructor
public class MongoDBRepository implements DBRepository {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
