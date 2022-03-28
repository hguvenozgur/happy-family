package com.happy.service.service;

import com.happy.exception.PositiveIntegerException;
import com.happy.model.Product;
import com.happy.repository.ProductRepository;
import com.happy.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTests {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void getMilkQtyShouldReturnSuccess() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));

        Assertions.assertEquals(productService.getMilkQty(), 1000);
    }

    @Test
    public void getEggsQtyShouldReturnSuccess() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));

        Assertions.assertEquals(productService.getEggsQty(), 1001);
    }

    @Test
    public void buyMilkShouldReturnSuccess() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));
        when(productRepository.save(any())).thenReturn(new Product());

        Assertions.assertEquals(productService.buyMilk(1), 1);

    }

    @Test
    public void buyMilkShouldThrowException() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));
        when(productRepository.save(any())).thenReturn("");

        Assertions.assertThrows(PositiveIntegerException.class, ()->productService.buyMilk(-1));
    }

    @Test
    public void buyEggShouldReturnSuccess() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));
        when(productRepository.save(any())).thenReturn(new Product());

        Assertions.assertEquals(productService.buyEggs(1), 1);

    }

    @Test
    public void buyEggShouldThrowException() {
        Product mockProduct = new Product();
        mockProduct.setMilkQty(1000);
        mockProduct.setEggQty(1001);
        mockProduct.setStoreId(1);
        when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));
        when(productRepository.save(any())).thenReturn("");

        Assertions.assertThrows(PositiveIntegerException.class, ()->productService.buyEggs(-1));
    }
}
