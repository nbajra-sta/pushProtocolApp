package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class OrderStatus {
    private String orderNumber;
    private String status;

    public OrderStatus(String orderNumber, String status) {
        this.orderNumber = orderNumber;
        this.status = status;
    }
}
