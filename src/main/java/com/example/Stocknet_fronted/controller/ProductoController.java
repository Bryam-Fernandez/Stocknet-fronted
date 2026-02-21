package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listar(Model model) {

        model.addAttribute("productos", productoService.listar());
        return "productos/lista";
    }

    @GetMapping("/productos/{id}")
    public String detalle(@PathVariable Long id, Model model) {

        model.addAttribute("producto", productoService.buscarPorId(id));
        return "productos/detalle";
    }
}