package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final List<Pedido> pedidos = new ArrayList<>();

    public PedidoService() {
        pedidos.add(new Pedido(1L, "Cliente A", LocalDate.now(), "REGISTRADO", 250.00));
        pedidos.add(new Pedido(2L, "Cliente B", LocalDate.now().minusDays(1), "PROCESADO", 420.00));
        pedidos.add(new Pedido(3L, "Cliente C", LocalDate.now().minusDays(2), "ENVIADO", 180.00));
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public Pedido buscarPorId(Long id) {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void guardar(Pedido pedido) {
        pedido.setId((long) (pedidos.size() + 1));
        pedidos.add(pedido);
    }

    public int totalPedidos() {
        return pedidos.size();
    }
}
