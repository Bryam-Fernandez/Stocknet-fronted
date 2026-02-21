//package com.example.Stocknet_fronted.service;
//
//import com.example.Stocknet_fronted.model.Pedido;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class OrderClient {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private static final String ORDER_SERVICE_URL =
//            "http://localhost:8081"; // puerto real de tu order-service
//
//    public List<Pedido> listarPedidos() {
//
//        Pedido[] pedidos = restTemplate.getForObject(
//                ORDER_SERVICE_URL + "/pedidos",
//                Pedido[].class
//        );
//
//        return Arrays.asList(pedidos);
//    }
//
//    public Pedido buscarPorId(Long id) {
//
//        return restTemplate.getForObject(
//                ORDER_SERVICE_URL + "/pedidos/" + id,
//                Pedido.class
//        );
//    }
//
//}