package pl.hycom.demo.infrastrucutre.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.hycom.demo.domain.repository.DBRepository;
import pl.hycom.demo.domain.repository.User;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MongoDBRepository implements DBRepository {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
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
