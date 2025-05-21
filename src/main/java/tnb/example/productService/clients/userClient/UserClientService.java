package tnb.example.productService.clients.userClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class UserClientService {

    private final RestTemplate restTemplate;

    @Value("${user.service.base-url}")
    private String userServiceBaseUrl; // ex: lb://user-service

    public UserClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserClientDto getUserById(Long id) {
        try {
            String url = userServiceBaseUrl + "/users/" + id;
            return restTemplate.getForObject(url, UserClientDto.class);
        } catch (RestClientException ex) {
            throw new RuntimeException("Erreur lors de l'appel à user-service : " + ex.getMessage(), ex);
        }
    }
}
