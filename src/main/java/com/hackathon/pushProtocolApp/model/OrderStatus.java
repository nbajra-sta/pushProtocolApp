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

    public String getOrderNumber(){
        return orderNumber;
    }
    public String getStatus(){
        return status;
    }
    public void setOrderNumber(String orderNumber){
        this.orderNumber = orderNumber;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
