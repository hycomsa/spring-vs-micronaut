package pl.hycom.demo.application;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import pl.hycom.demo.domain.service.UserService;

import java.util.Collection;

@Controller("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Post
    public HttpResponse<UserDto> upsertUser(UserDto userDto) {
        return HttpResponse.created(userService.upsertUser(userDto));
    }

    @Get
    public HttpResponse<Collection<UserDto>> findAll() {
        return HttpResponse.ok(userService.findAll());
    }

    @Get( "/{id}")
    public HttpResponse<UserDto> findById(@PathVariable String id) {
        return userService.findById(id).map(HttpResponse::ok).orElseGet(HttpResponse::notFound);
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return HttpResponse.noContent();
    }
}
