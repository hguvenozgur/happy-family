package com.java.happyfamily.orms;

import com.java.happyfamily.model.orms.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductModelTests {

    private static ProductModel productModel;

    @BeforeAll
    public static void init() {
        productModel = new ProductModel(1, 5, "test", "test", 3, null);
    }

    @Test
    public void getAllValuesReturnSuccess(){
        Assertions.assertEquals(productModel.getQuantity(), 5);
        Assertions.assertEquals(productModel.getId(), 1);
        Assertions.assertEquals(productModel.getBrand(), "test");
        Assertions.assertEquals(productModel.getPrice(), 3);
        Assertions.assertEquals(productModel.getName(), "test");
        Assertions.assertEquals(productModel.getQuantityMetric(), null);
    }
}
