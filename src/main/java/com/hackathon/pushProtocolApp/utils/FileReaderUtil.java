package com.hackathon.pushProtocolApp.utils;

import com.hackathon.pushProtocolApp.model.CartItem;
import com.hackathon.pushProtocolApp.model.DataRecord;
import com.hackathon.pushProtocolApp.model.OrderDetails;
import com.hackathon.pushProtocolApp.model.OrderStatus;
import com.hackathon.pushProtocolApp.model.Promotion;
import com.hackathon.pushProtocolApp.model.WishListItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileReaderUtil {
    public List<DataRecord> readData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = new ClassPathResource("dataset.json").getFile().getPath();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return objectMapper.readValue(json, new TypeReference<List<DataRecord>>() {});
    }




     public List<CartItem> readCartItems() {
        // Mocked or file-loaded logic
        return List.of(
            new CartItem("Wireless Mouse", 25.99),
            new CartItem("Mechanical Keyboard", 89.99),
            new CartItem("USB-C Hub", 39.50)
        );
    }

    public List<WishListItem> readWishListItems() {
        return List.of(
            new WishListItem("Razor keyboard", 25.99),
            new WishListItem("La-Z-Boy Arcadian Bonded Leather Executive Chair", 219.99),
            new WishListItem("Staples Carpet Chair Mat with Lip", 39.50)
        );
    }

    public List<OrderStatus> readOrderStatuses() {
        return List.of(
            new OrderStatus("12222", "confirmed"),
            new OrderStatus("121282", "shipped"),
            new OrderStatus("1445", "out for delivery")
        );
    }

    public List<Promotion> readPromotions() {
        return List.of(
            new Promotion("10-peice gardening set with your regular priced order of $150 or more", "27th April 2025"),
            new Promotion("25% off regular priced scotch packing tape", "30th April 2025")
        );
    }

    public OrderDetails readOrderDetails() {
        return new OrderDetails("Razor keyboard", "$25", "pending");
    }
}

