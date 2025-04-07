package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class WishListItem {
    private String name;
    private double price;

    public WishListItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
