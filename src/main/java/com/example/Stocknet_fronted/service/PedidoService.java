package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    public List<Pedido> listar() {
        return new ArrayList<>();
    }

    public Pedido buscarPorId(Long id) {

        Pedido p = new Pedido();
        p.setId(id);
        p.setCliente("Cliente demo");

        return p;
    }

    public void guardar(Pedido pedido) {
        // no hace nada (fase diseño)
    }
}