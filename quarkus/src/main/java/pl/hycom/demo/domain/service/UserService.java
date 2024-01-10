package pl.hycom.demo.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import pl.hycom.demo.application.UserDto;
import pl.hycom.demo.domain.repository.DBRepository;

import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class UserService {

    private final DBRepository dbRepository;
    private final UserMapper userMapper;

    public UserDto upsertUser(UserDto userDto) {
        return userMapper.map(dbRepository.save(userMapper.map(userDto)));
    }

    public Collection<UserDto> findAll() {
        return dbRepository.findAll().stream().map(userMapper::map).toList();
    }

    public Optional<UserDto> findById(String id) {
        return dbRepository.findById(id).map(userMapper::map);
    }

    public void deleteById(String id) {
        dbRepository.deleteById(id);
    }
}
