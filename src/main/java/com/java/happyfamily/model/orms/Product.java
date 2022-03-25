package com.java.happyfamily.model.orms;

import com.java.happyfamily.model.common.QuantityMetric;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    private @Id @GeneratedValue Integer id;
    private int quantity;
    private String name;
    private String brand;
    private double price;
    private String quantityMetric;

    public Product() {
    }

    Product(int id, int quantity, String name, String brand, double price, String quantityMetric){

        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantityMetric = quantityMetric;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getQuantityMetric() {
        return quantityMetric;
    }

    public void setQuantityMetric(String quantityMetric) {
        this.quantityMetric = quantityMetric;
    }
}
