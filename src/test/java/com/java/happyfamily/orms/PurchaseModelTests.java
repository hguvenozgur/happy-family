package com.java.happyfamily.orms;


import com.java.happyfamily.model.orms.PurchaseModel;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PurchaseModelTests {

    private static PurchaseModel purchaseModel;

    @BeforeAll
    public static void init(){
        purchaseModel = new PurchaseModel();
        purchaseModel.setPurchaser("test");
        purchaseModel.setId(1);
        purchaseModel.setQuantity(5);
        purchaseModel.setDescription("test");
        purchaseModel.setPayment("test");
        purchaseModel.setProductId(1);
    }

    @Test
    public void getAllValusReturnSuccess(){
        Assertions.assertEquals(purchaseModel.getPurchaser(), "test");
        Assertions.assertEquals(purchaseModel.getDescription(), "test");
        Assertions.assertEquals(purchaseModel.getPayment(), "test");
        Assertions.assertEquals(purchaseModel.getQuantity(), 5);
        Assertions.assertEquals(purchaseModel.getProductId(), 1);
    }
}
