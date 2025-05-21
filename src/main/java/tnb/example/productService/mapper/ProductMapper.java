package tnb.example.productService.mapper;

import tnb.example.productService.dto.ProductDto;
import tnb.example.productService.entities.Product;

import java.util.function.Function;
import java.util.function.Function;

public class ProductMapper implements Function<Product, ProductDto> {

    @Override
    public ProductDto apply(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getUserId(),
                product.getUserClient() // Peut être null si non encore enrichi
        );
    }
}
