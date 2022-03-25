package com.java.happyfamily.model.orms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseModel {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO)Integer id;
    private int productId;
    private String purchaser;
    private int quantity;
    private String payment;
    private String description;

    public PurchaseModel() {
    }

    public PurchaseModel(int productId, String purchaser, int quantity, String payment, String description) {
        this.productId = productId;
        this.purchaser = purchaser;
        this.quantity = quantity;
        this.payment = payment;
        this.description = description;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
