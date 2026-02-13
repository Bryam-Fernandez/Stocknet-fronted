package com.example.Stocknet_fronted.service;

import com.example.Stocknet_fronted.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventarioService {

    private final List<Producto> productos = new ArrayList<>();

    public InventarioService() {
        productos.add(new Producto(1L, "Teclado", 25, 80.00));
        productos.add(new Producto(2L, "Mouse", 40, 35.50));
        productos.add(new Producto(3L, "Monitor", 12, 650.00));
    }


    public List<Producto> listar() {
        return productos;
    }

    public Producto buscarPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void guardar(Producto producto) {

        if (producto.getId() != null) {

            for (int i = 0; i < productos.size(); i++) {

                if (productos.get(i).getId().equals(producto.getId())) {
                    productos.set(i, producto);
                    return;
                }
            }
        }
        producto.setId((long) (productos.size() + 1));
        productos.add(producto);
    }

}
