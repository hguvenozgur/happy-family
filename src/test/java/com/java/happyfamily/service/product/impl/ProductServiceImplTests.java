package com.java.happyfamily.service.product.impl;

import com.java.happyfamily.model.orms.ProductModel;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.persistence.ProductRepository;
import com.java.happyfamily.service.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTests {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void allProductsShouldReturnProductList() throws Exception{
        when(productRepository.findAll()).thenReturn(Arrays.asList(
                new ProductModel(1, 5, "test1", "test1", 2, null),
                new ProductModel(2, 10, "test2", "test2", 3, null),
                new ProductModel(3, 15, "test3", "test3", 4, null),
                new ProductModel(4, 205, "test4", "test4", 5, null)));
        List products = productService.getAllProducts();
        Assertions.assertEquals(products.size(), 4);

    }

    @Test
    public void allProductsShouldThrowException() throws Exception{
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertThrows(Exception.class, ()->productService.getAllProducts());
    }
    @Test
    public void productDetailShouldReturnDetail() throws Exception{
        ProductModel mockModel = new ProductModel(1, 10, "test",
                "test", 5, null);
        when(productRepository.findById(any())).thenReturn(
                Optional.of(mockModel));

        ProductDetail productDetail = productService.getProductDetail(1);

        Assertions.assertEquals(productDetail.getQuantity(), mockModel.getQuantity());
        Assertions.assertEquals(productDetail.getId(), mockModel.getId());
        Assertions.assertEquals(productDetail.getBrand(), mockModel.getBrand());
    }

    @Test
    public void notExistProductDetailShouldThrowException() throws Exception{
        ProductModel mockModel = new ProductModel(1, 10, "test", "test",
                5, null);
        when(productRepository.findById(1)).thenReturn(
                Optional.of(mockModel));

        Assertions.assertThrows(Exception.class, ()->productService.getProductDetail(2));
    }

    @Test
    public void sellProductReturnsSuccess() throws Exception{
        ProductModel mockModel = new ProductModel(1, 10, "test", "test",
                5, null);
        when(productRepository.getById(1)).thenReturn(mockModel);

        ProductDetail productDetail = productService.sellProduct(1, 5);
        Assertions.assertEquals(5, productDetail.getQuantity());

    }

    @Test
    public void sellNotExistingNumberOfProductThrowException() throws Exception{
        ProductModel mockModel = new ProductModel(1, 4, "test", "test",
                5, null);
        when(productRepository.getById(1)).thenReturn(mockModel);

        Assertions.assertThrows(Exception.class, ()->productService.sellProduct(1, 5));


    }


}
