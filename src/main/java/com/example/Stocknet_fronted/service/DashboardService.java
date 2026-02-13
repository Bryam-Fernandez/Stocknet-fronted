package com.example.Stocknet_fronted.service;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final PedidoService pedidoService;
    private final InventarioService inventarioService;

    public DashboardService(PedidoService pedidoService,
                            InventarioService inventarioService) {
        this.pedidoService = pedidoService;
        this.inventarioService = inventarioService;
    }

    public int totalPedidos() {
        return pedidoService.totalPedidos();
    }

    public int productosBajoStock() {
        return (int) inventarioService.listar()
                .stream()
                .filter(p -> p.getStock() < 20)
                .count();
    }

    public int pedidosHoy() {
        return 2; // Simulado
    }
}
