package com.java.happyfamily.service.purchase.impl;

import com.java.happyfamily.model.orms.ProductModel;
import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.model.purchase.Item;
import com.java.happyfamily.persistence.PurchaseRepository;
import com.java.happyfamily.service.product.ProductService;
import com.java.happyfamily.service.purchase.PurchaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PurchaseServiceImplTests {

    @Autowired
    PurchaseService purchaseService;

    @MockBean
    ProductService productService;

    @MockBean
    PurchaseRepository purchaseRepository;



    @Test
    public void shouldBuyProductReturnSuccess() throws Exception{
        ProductDetail mockProductDetail = new ProductDetail();
        mockProductDetail.setType("test");
        mockProductDetail.setId(1);
        mockProductDetail.setQuantity(10);
        mockProductDetail.setBrand("test");

        when(productService.getProductDetail(any())).thenReturn(mockProductDetail);
        when(purchaseRepository.save(any())).thenReturn(null);
        when(productService.sellProduct(1, 2)).thenReturn(mockProductDetail);

        Item mockItem = new Item();
        mockItem.setQuantity(5);
        mockItem.setProduct(new Product(1, "test"));
        Assertions.assertDoesNotThrow(()->purchaseService.buyProduct(mockItem));
    }

    @Test
    public void shouldBuyProductThrowException() throws Exception{
        ProductDetail mockProductDetail = new ProductDetail();
        mockProductDetail.setType("test");
        mockProductDetail.setId(1);
        mockProductDetail.setQuantity(10);
        mockProductDetail.setBrand("test");

        when(productService.getProductDetail(any())).thenReturn(mockProductDetail);
        when(purchaseRepository.save(any())).thenReturn(null);
        when(productService.sellProduct(1, 2)).thenReturn(mockProductDetail);

        Item mockItem = new Item();
        mockItem.setQuantity(11);
        mockItem.setProduct(new Product(1, "test"));
        Assertions.assertThrows(Exception.class, ()->purchaseService.buyProduct(mockItem));
    }
}
