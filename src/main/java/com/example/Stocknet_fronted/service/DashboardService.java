package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.model.OrderView;
import com.example.Stocknet_fronted.model.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DashboardService {

    private final RestTemplate restTemplate;

    @Value("${stocknet.api.orders}")
    private String ordersApi;

    @Value("${stocknet.api.productos}")
    private String productsApi;

    public DashboardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // -------------------------
    // Total de pedidos
    // -------------------------
    public int totalPedidos() {

        OrderView[] pedidos = restTemplate.getForObject(
                ordersApi,
                OrderView[].class
        );

        if (pedidos == null) return 0;

        return pedidos.length;
    }

    // -------------------------
    // Pedidos de hoy (simple)
    // -------------------------
    public int pedidosHoy() {

        OrderView[] pedidos = restTemplate.getForObject(
                ordersApi,
                OrderView[].class
        );

        if (pedidos == null) return 0;

        LocalDate hoy = LocalDate.now();

        return (int) Arrays.stream(pedidos)
                .filter(p ->
                        p.getCreatedAt() != null &&
                        p.getCreatedAt().toLocalDate().equals(hoy)
                )
                .count();
    }

    // -------------------------
    // Productos con bajo stock
    // (ej: stock <= 5)
    // -------------------------
    public int productosBajoStock() {

        Producto[] productos = restTemplate.getForObject(
                productsApi,
                Producto[].class
        );

        if (productos == null) return 0;

        return (int) Arrays.stream(productos)
                .filter(p -> p.getStock() != null && p.getStock() <= 5)
                .count();
    }

}