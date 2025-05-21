package tnb.example.productService.dto;
public record ProductRequestDto(
        String name,
        String description,
        Double price,
        Long userId
) {}
