package pl.hycom.demo.domain.repository;

import java.util.List;
import java.util.Optional;

public interface DBRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(String id);
    void deleteById(String id);
}
