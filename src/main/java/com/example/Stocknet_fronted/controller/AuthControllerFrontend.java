package com.example.Stocknet_fronted.controller;

import com.example.Stocknet_fronted.dto.LoginRequest;
import com.example.Stocknet_fronted.dto.RegistroRequest;
import com.example.Stocknet_fronted.model.Usuario;
import com.example.Stocknet_fronted.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthControllerFrontend {

    private final AuthService authService;

    public AuthControllerFrontend(AuthService authService) {
        this.authService = authService;
    }
    
    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/login";
    }

    // ================= LOGIN =================
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute LoginRequest loginRequest, Model model, HttpSession session) {
        try {
            Usuario usuario = authService.login(loginRequest);
            session.setAttribute("usuario", usuario);
            return "redirect:/dashboard"; // Página después del login
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "login/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // ================= REGISTER =================
    @GetMapping("/register")
    public String mostrarRegistro(Model model) {
        model.addAttribute("registroRequest", new RegistroRequest());
        return "login/register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute RegistroRequest registroRequest, Model model) {
        try {
            Usuario usuario = authService.registrar(registroRequest); // Llama al backend de auth
            return "redirect:/login"; // Redirige al login después de registrarse
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo registrar: " + e.getMessage());
            return "login/register";
        }
    }
}