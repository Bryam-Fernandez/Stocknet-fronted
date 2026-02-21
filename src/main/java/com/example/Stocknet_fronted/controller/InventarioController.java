//package com.example.Stocknet_fronted.controller;
//
//import com.example.Stocknet_fronted.service.ProductClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class InventarioController {
//
//    private final ProductClient productClient;
//
//    public InventarioController(ProductClient productClient) {
//        this.productClient = productClient;
//    }
//
//    @GetMapping("/inventario")
//    public String listarInventario(Model model) {
//
//        model.addAttribute("productos", productClient.listarProductos());
//        return "inventario/lista";
//    }
//
//    @GetMapping("/inventario/editar/{id}")
//    public String editarProducto(@PathVariable Long id, Model model) {
//
//        model.addAttribute("producto", productClient.buscarPorId(id));
//        return "inventario/editar";
//    }
//
//}