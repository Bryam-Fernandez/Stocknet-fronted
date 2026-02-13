package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {

        model.addAttribute("totalPedidos", dashboardService.totalPedidos());
        model.addAttribute("pedidosHoy", dashboardService.pedidosHoy());
        model.addAttribute("productosBajoStock", dashboardService.productosBajoStock());

        return "dashboard/index";
    }
}
