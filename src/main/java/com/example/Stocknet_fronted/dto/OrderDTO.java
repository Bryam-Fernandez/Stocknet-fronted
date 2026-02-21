package com.example.Stocknet_fronted.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long clientId;
    private List<OrderItemDTO> items = new ArrayList<>();

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}