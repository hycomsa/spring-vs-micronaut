package pl.hycom.demo.application;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import pl.hycom.demo.domain.service.UserService;

@Path("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @POST
    public Response upsertUser(UserDto userDto) {
        return Response.created(null).entity(userService.upsertUser(userDto)).build();

    }

    @GET
    public Response findAll() {
        return Response.ok(userService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        return userService.findById(id).map(u -> Response.ok(u).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        userService.deleteById(id);
        return Response.noContent().build();
    }
}
