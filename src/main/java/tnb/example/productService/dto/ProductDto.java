package tnb.example.productService.dto;

import tnb.example.productService.clients.userClient.UserClientDto;

public record ProductDto(
        Long id,
        String name,
        String description,
        Double price,
        String userId,
        UserClientDto userClient
) {}

