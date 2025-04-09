package com.hackathon.pushProtocolApp.model;
import lombok.Data;

@Data
public class Promotion {
    private String promotion;
    private String expires;
    
    public Promotion(String promotion, String expires) {
        this.promotion = promotion;
        this.expires = expires;
    }
    public String getExpires(){
        return expires;
    }
    public String getPromotion(){
        return promotion;
    }
    public void setPromotion(String promotion){
        this.promotion = promotion;
    }
    public void setExpires(String expires){
        this.expires = expires;
    }

}
