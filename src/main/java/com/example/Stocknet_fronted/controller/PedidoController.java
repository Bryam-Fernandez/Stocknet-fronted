package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.model.Pedido;
import com.example.Stocknet_fronted.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {

        model.addAttribute("pedidos", pedidoService.listar());

        return "pedidos/lista";
    }

    @GetMapping("/pedidos/nuevo")
    public String nuevoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedidos/nuevo";
    }

    @PostMapping("/pedidos/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.guardar(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/{id}")
    public String detallePedido(@PathVariable Long id, Model model) {

        model.addAttribute("pedido", pedidoService.buscarPorId(id));

        return "pedidos/detalle";
    }
}
