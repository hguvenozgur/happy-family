package com.happy.service.model;

import com.happy.model.EggsQtyResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EggsQtyResultTests {

    private static EggsQtyResult eggsQtyResult;

    @BeforeAll
    public static void setup(){
        eggsQtyResult = new EggsQtyResult(5);
    }

    @Test
    public void getAllValuesShouldReturnSuccess(){
        Assertions.assertEquals(eggsQtyResult.getEggs(), 5);
        Assertions.assertDoesNotThrow(()->eggsQtyResult.setEggs(1));
        Assertions.assertEquals(eggsQtyResult.getEggs(), 1);
    }
}
