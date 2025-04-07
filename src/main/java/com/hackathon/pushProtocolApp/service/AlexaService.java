package com.hackathon.pushProtocolApp.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.io.IOException;
import java.net.http.HttpRequest;
import org.springframework.stereotype.Service;
import com.hackathon.pushProtocolApp.model.CartItem;
import com.hackathon.pushProtocolApp.model.OrderDetails;
import com.hackathon.pushProtocolApp.model.OrderStatus;
import com.hackathon.pushProtocolApp.model.Promotion;
import com.hackathon.pushProtocolApp.model.WishListItem;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


@Service
public class AlexaService {
    @Value("${alexa.api.token}")
    private String accessToken;
  
    public List<CartItem> getCartItems() {
        return List.of(
            new CartItem("Razor keyboard", 25.99),
            new CartItem("La-Z-Boy Arcadian Bonded Leather Executive Chair", 219.99),
            new CartItem("Staples Carpet Chair Mat with Lip", 39.50)
            );
        }

    public List<WishListItem> getWishListItems() {
        return List.of(
            new WishListItem("Razor keyboard", 25.99),
            new WishListItem("La-Z-Boy Arcadian Bonded Leather Executive Chair", 219.99),
            new WishListItem("Staples Carpet Chair Mat with Lip", 39.50)
        );
    }

    public List<OrderStatus> getOrderStatus() {
        return List.of(
            new OrderStatus("12222", "confirmed"),
            new OrderStatus("121282", "shipped"),
            new OrderStatus("1445", "out for delivery")
        );
    }

    public List<Promotion> getPromotions() {
        return List.of(
            new Promotion("10-peice gardening set with your regular priced order of $150 or more", "27th April 2025"),
            new Promotion("25% off regular priced scotch packing tape", "30th April 2025")
        );
    }

    public OrderDetails getOrderDetails() {
        return new OrderDetails("Razor keyboard", "$25", "pending");
    }

    public String reorderProduct(String productName) {
        // Simulate reorder
        return "Reorder placed for: " + productName;
    }



public void notifyAlexa(String message) {
    String endpoint = "https://api.amazonalexa.com/v1/directives";
    String accessToken = "YOUR_OAUTH_ACCESS_TOKEN";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(accessToken);

    String payload = buildDirectivePayload(message);
    HttpEntity<String> entity = new HttpEntity<>(payload, headers);

    ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);
    System.out.println("Alexa Response: " + response.getStatusCodeValue());
    System.out.println("Body: " + response.getBody());

    try {
       
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(buildDirectivePayload(message)))
            .build();

        HttpResponse<String> Httpresponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Alexa Notification Response: " + Httpresponse.statusCode() + " " + Httpresponse.body());

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String buildDirectivePayload(String message) {
    return """
    {
      "directive": {
        "type": "VoicePlayer.Speak",
        "speech": "%s"
      }
    }
    """.formatted(message);
}



public void sendAlexa(String message) {
    try {
        String Sendendpoint = "https://api.amazonalexa.com/v1/directives";
        String accessToken = "YOUR_OAUTH_ACCESS_TOKEN"; // Replace with a real access token

        String payload = """
        {
            "directive": {
                "type": "VoicePlayer.Speak",
                "speech": "%s"
            }
        }
        """.formatted(message);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Sendendpoint))
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Alexa response: " + response.statusCode());
        System.out.println("Response body: " + response.body());

    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}


}
