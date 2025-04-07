package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class Promotion {
    private String promotion;
    private String expires;
    
    public Promotion(String promotion, String expires) {
        this.expires = expires;
        this.expires = expires;
    }
}
