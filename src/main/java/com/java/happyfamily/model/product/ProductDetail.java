package com.java.happyfamily.model.product;

import com.java.happyfamily.model.common.QuantityMetric;

public class ProductDetail {

    private Integer id;
    private String type;
    private String brand;
    private double price;
    private int quantity;
    private QuantityMetric quantityMetric;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public QuantityMetric getQuantityMetric() {
        return quantityMetric;
    }

    public void setQuantityMetric(QuantityMetric quantityMetric) {
        this.quantityMetric = quantityMetric;
    }
}
