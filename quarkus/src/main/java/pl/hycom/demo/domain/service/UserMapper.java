package pl.hycom.demo.domain.service;

import org.mapstruct.Mapper;
import pl.hycom.demo.application.UserDto;
import pl.hycom.demo.domain.repository.User;

@Mapper(componentModel = "jakarta")
public interface UserMapper {
    UserDto map(User user);

    User map(UserDto userDto);
}
