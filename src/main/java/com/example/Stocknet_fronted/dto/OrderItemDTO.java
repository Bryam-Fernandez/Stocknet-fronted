package com.example.Stocknet_fronted.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItemDTO {

    private Long productId;
    
    @JsonProperty("quantity")
    private Integer cantidad;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}