package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.model.Producto;
import com.example.Stocknet_fronted.service.InventarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/inventario")
    public String listarInventario(Model model) {

        model.addAttribute("productos", inventarioService.listar());

        return "inventario/lista";
    }

    @GetMapping("/inventario/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "inventario/nuevo";
    }

    @PostMapping("/inventario/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        inventarioService.guardar(producto);
        return "redirect:/inventario";
    }

    @GetMapping("/inventario/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {

        model.addAttribute("producto", inventarioService.buscarPorId(id));

        return "inventario/editar";
    }
}
