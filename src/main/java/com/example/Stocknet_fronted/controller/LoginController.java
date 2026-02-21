//package com.example.Stocknet_fronted.controller;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public String login() {
//        return "login/login";
//    }
//
//    @PostMapping("/login")
//    public String procesarLogin(@RequestParam String usuario,
//                                @RequestParam String password,
//                                HttpSession session) {
//
//        if (usuario.equals("admin") && password.equals("1234")) {
//            session.setAttribute("usuario", usuario);
//            return "redirect:/dashboard";
//        }
//
//        return "redirect:/login?error";
//    }
//}
