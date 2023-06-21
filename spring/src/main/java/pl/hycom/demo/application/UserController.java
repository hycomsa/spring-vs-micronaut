package pl.hycom.demo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.hycom.demo.domain.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> upsertUser(UserDto userDto, UriComponentsBuilder builder) {
        UserDto createdUser = userService.upsertUser(userDto);
        UriComponents uriComponents = builder.path("/api/users/{id}").buildAndExpand(createdUser.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        return userService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
