package com.hackathon.pushProtocolApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.pushProtocolApp.model.CartItem;
import com.hackathon.pushProtocolApp.model.OrderDetails;
import com.hackathon.pushProtocolApp.model.OrderStatus;
import com.hackathon.pushProtocolApp.model.Promotion;
import com.hackathon.pushProtocolApp.model.WishListItem;
import com.hackathon.pushProtocolApp.service.AlexaService;

@RestController
@RequestMapping("/api")
public class AlexaController {

    private final AlexaService service;

    public AlexaController(AlexaService service) {
        this.service = service;
    }

    @GetMapping("/cart")
    public List<CartItem> getCartItems() {
        return service.getCartItems();
    }

    @GetMapping("/wishlist")
    public List<WishListItem> getWishListItems() {
        return service.getWishListItems();
    }

    @GetMapping("/orders/status")
    public List<OrderStatus> getOrderStatus() {
        return service.getOrderStatus();
    }

    @GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return service.getPromotions();
    }

    @GetMapping("/orders/details")
    public OrderDetails getOrderDetails() {
        return service.getOrderDetails();
    }

    @PostMapping("/orders/reorder")
    public ResponseEntity<String> reorder(@RequestParam String productName) {
        return ResponseEntity.ok(service.reorderProduct(productName));
    }

    @PostMapping("/notifications/order-update")
    public ResponseEntity<Void> notifyAlexa(@RequestParam String message) {
        service.notifyAlexa(message);
        return ResponseEntity.ok().build();
    }

    // send notification to alex
    @PostMapping("/notifications/send-update")
    public ResponseEntity<Void> sendAlexa(@RequestParam String message) {
        service.sendAlexa(message);
        return ResponseEntity.ok().build();
    }
}

