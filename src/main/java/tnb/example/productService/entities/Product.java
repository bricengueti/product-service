package tnb.example.productService.entities;

import jakarta.persistence.*;
import tnb.example.productService.clients.userClient.UserClientDto;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String userId;
    @Transient
    private UserClientDto userClient;

    public Product(Long id, String name, String description, Double price, String userId, UserClientDto userClient) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.userClient = userClient;
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserClientDto getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClientDto userClient) {
        this.userClient = userClient;
    }
}
