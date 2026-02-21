package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.model.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {

    private final RestTemplate restTemplate;

    @Value("${stocknet.api.productos}")
    private String productosApi;

    public ProductoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Producto> listar() {

        Producto[] productos =
                restTemplate.getForObject(productosApi, Producto[].class);

        return Arrays.asList(productos);
    }

    public Producto buscarPorId(Long id) {

        return restTemplate.getForObject(
                productosApi + "/" + id,
                Producto.class
        );
    }
}