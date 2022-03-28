package com.happy.service.model;

import com.happy.model.EggsQtyResult;
import com.happy.model.ErrorRestResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ErrorRestResultTests {

    private static ErrorRestResult errorRestResult;

    @BeforeAll
    public static void setup(){
        errorRestResult = new ErrorRestResult(400, "Test");
    }

    @Test
    public void getAllValuesShouldReturnSuccess(){
        Assertions.assertEquals(errorRestResult.getError_code(), 400);
        Assertions.assertEquals(errorRestResult.getError_msg(), "Test");
        Assertions.assertDoesNotThrow(()->errorRestResult.setError_code(500));
        Assertions.assertDoesNotThrow(()->errorRestResult.setError_msg("Test cont"));
        Assertions.assertEquals(errorRestResult.getError_code(), 500);
        Assertions.assertEquals(errorRestResult.getError_msg(), "Test cont");
    }
}
