package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.dto.LoginRequest;
import com.example.Stocknet_fronted.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {

    private final RestTemplate restTemplate;
    private final String authApiUrl;

    public UsuarioService(RestTemplate restTemplate,
                          @Value("${stocknet.api.auth}") String authApiUrl) {
        this.restTemplate = restTemplate;
        this.authApiUrl = authApiUrl;
    }

    public Usuario login(String username, String password) {
        LoginRequest request = new LoginRequest(username, password);
        return restTemplate.postForObject(authApiUrl + "/login", request, Usuario.class);
    }

    public Usuario registrar(Usuario usuario) {
        return restTemplate.postForObject(authApiUrl + "/register", usuario, Usuario.class);
    }

    public Usuario buscarPorUsername(String username) {
        return restTemplate.getForObject(authApiUrl + "/" + username, Usuario.class);
    }
}