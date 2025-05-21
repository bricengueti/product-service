package tnb.example.productService.clients.userClient;

public record UserClientDto(
        String id,
        String username,
        String email,
        String firstName,
        String lastName
) {

}
