package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class CartItem {
    private String name;
    private double price;

    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
