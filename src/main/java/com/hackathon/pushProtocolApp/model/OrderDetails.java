package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class OrderDetails {
    private String product;
    private String price;
    private String status;

    public OrderDetails(String product, String price, String status) {
        this.product = product;
        this.price = price;
        this.status = status;
    }
}
