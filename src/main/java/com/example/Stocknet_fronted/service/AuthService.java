package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.dto.LoginRequest;
import com.example.Stocknet_fronted.dto.RegistroRequest;
import com.example.Stocknet_fronted.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;
    private final String authLoginUrl;
    private final String authRegisterUrl;

    public AuthService(RestTemplate restTemplate, @Value("${stocknet.api.auth}") String authBaseUrl) {
        this.restTemplate = restTemplate;
        this.authLoginUrl = authBaseUrl + "/login";
        this.authRegisterUrl = authBaseUrl + "/register";
    }

    public Usuario login(LoginRequest loginRequest) {
        return restTemplate.postForObject(authLoginUrl, loginRequest, Usuario.class);
    }

    public Usuario registrar(RegistroRequest registroRequest) {
        return restTemplate.postForObject(authRegisterUrl, registroRequest, Usuario.class);
    }
}