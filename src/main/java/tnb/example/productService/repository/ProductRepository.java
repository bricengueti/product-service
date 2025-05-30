package tnb.example.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tnb.example.productService.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
