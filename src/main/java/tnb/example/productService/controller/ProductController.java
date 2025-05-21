package tnb.example.productService.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tnb.example.productService.dto.ProductDto;
import tnb.example.productService.dto.ProductRequestDto;
import tnb.example.productService.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    // Constructeur
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductRequestDto requestDto) {
        ProductDto productDto = productService.createProduct(requestDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }
}