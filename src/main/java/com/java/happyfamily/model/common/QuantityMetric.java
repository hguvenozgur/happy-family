package com.java.happyfamily.model.common;

public enum QuantityMetric {
    PIECE("Piece"), KG("Kilogram"), L("Litre");

    public final String type;

    QuantityMetric(String type){
        this.type = type;
    }
}
