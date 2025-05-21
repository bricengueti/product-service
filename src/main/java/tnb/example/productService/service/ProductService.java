package tnb.example.productService.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tnb.example.productService.clients.userClient.UserClientDto;
import tnb.example.productService.clients.userClient.UserClientService;
import tnb.example.productService.dto.ProductDto;
import tnb.example.productService.dto.ProductRequestDto;
import tnb.example.productService.entities.Product;
import tnb.example.productService.mapper.ProductMapper;
import tnb.example.productService.repository.ProductRepository;
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserClientService userClientService;

    public ProductService(ProductRepository productRepository, UserClientService userClientService) {
        this.productRepository = productRepository;
        this.userClientService = userClientService;
    }
    @Transactional
    public ProductDto createProduct(ProductRequestDto requestDto) {
        // Appel synchrone via RestTemplate
        UserClientDto userClient;
        try {
            userClient = userClientService.getUserById(requestDto.userId());
        } catch (Exception ex) {
            throw new RuntimeException("Erreur lors de la récupération de l'utilisateur : " + ex.getMessage(), ex);
        }

        if (userClient == null) {
            throw new RuntimeException("Utilisateur introuvable avec l'ID : " + requestDto.userId());
        }

        // Création de l'entité Product
        Product product = new Product();
        product.setName(requestDto.name());
        product.setDescription(requestDto.description());
        product.setPrice(requestDto.price());
        product.setUserId(String.valueOf(requestDto.userId()));
        product.setUserClient(userClient); // enrichi si tu veux l’afficher dans le DTO

        // Enregistrement en base
        Product saved = productRepository.save(product);

        return new ProductMapper().apply(saved);
    }

}

