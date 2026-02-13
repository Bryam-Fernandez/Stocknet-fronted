package com.example.Stocknet_fronted.model;

import java.time.LocalDate;

public class Pedido {

    private Long id;
    private String cliente;
    private LocalDate fecha;
    private String estado;
    private double total;

    public Pedido() {
    }

    public Pedido(Long id, String cliente, LocalDate fecha, String estado, double total) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
