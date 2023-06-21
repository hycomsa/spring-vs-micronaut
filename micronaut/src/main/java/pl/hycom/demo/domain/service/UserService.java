package pl.hycom.demo.domain.service;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import pl.hycom.demo.application.UserDto;
import pl.hycom.demo.domain.repository.DBRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class UserService {

    private final DBRepository dbRepository;
    private final UserMapper userMapper;

    public UserDto upsertUser(UserDto userDto) {
        return userMapper.map(dbRepository.save(userMapper.map(userDto)));
    }

    public Collection<UserDto> findAll() {
        return dbRepository.findAll().stream().map(userMapper::map).collect(Collectors.toList());
    }

    public Optional<UserDto> findById(String id) {
        return dbRepository.findById(id).map(userMapper::map);
    }

    public void deleteById(String id) {
        dbRepository.deleteById(id);
    }
}
