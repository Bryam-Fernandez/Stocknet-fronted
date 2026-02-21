package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PedidoController {

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {

        // Lista vacía solo para que el diseño funcione
        List<Pedido> pedidos = new ArrayList<>();

        model.addAttribute("pedidos", pedidos);
        return "pedidos/lista";
    }

    @GetMapping("/pedidos/nuevo")
    public String nuevoPedido(Model model) {

        model.addAttribute("pedido", new Pedido());
        return "pedidos/nuevo";
    }

    @PostMapping("/pedidos/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {

        // ❌ no se guarda nada (fase diseño)
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/{id}")
    public String detallePedido(@PathVariable Long id, Model model) {

        // Pedido ficticio para mostrar la vista
        Pedido pedido = new Pedido();
        pedido.setId(id);

        model.addAttribute("pedido", pedido);
        return "pedidos/detalle";
    }
}