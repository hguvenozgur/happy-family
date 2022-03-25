package com.java.happyfamily.controller;

import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.service.product.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;



import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    private static List mockProducts;
    private static List<ProductDetail> mockProductDetails;

    @BeforeAll
    public static void setup(){
        mockProducts = new ArrayList();
        mockProducts.add(new Product(1, "test-1"));
        mockProducts.add(new Product(2, "test-2"));
        mockProducts.add(new Product(3, "test-3"));

        mockProductDetails = new ArrayList();

        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setId(1);
        productDetail1.setQuantity(10);
        productDetail1.setBrand("test-1");
        productDetail1.setType("test-1");
        mockProductDetails.add(productDetail1);
        ProductDetail productDetail2 = new ProductDetail();
        productDetail2.setId(1);
        productDetail2.setQuantity(10);
        productDetail2.setBrand("test-2");
        productDetail2.setType("test-2");
        mockProductDetails.add(productDetail2);

    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(productService).isNotNull();
    }



    @Test
    public void allProductsShouldReturnsFromProductService() throws Exception{
        when(productService.getAllProducts()).thenReturn(mockProducts);

        this.mockMvc.perform(get("/store/products")).andDo(print()).andExpect(status().isOk()).andExpect(
                content().string(containsString("test-1"))
        );
    }

    @Test
    public void productDetailShouldReturnTest1() throws Exception{
        when(productService.getProductDetail(1)).thenReturn(mockProductDetails.get(0));

        this.mockMvc.perform(get("/store/product/detail/1")).andDo(print()).andExpect(status().isOk()).andExpect(
                content().string(containsString("test-1"))
        );
    }

    @Test
    public void productDetailShouldReturnTest2() throws Exception{
        when(productService.getProductDetail(2)).thenReturn(mockProductDetails.get(1));

        this.mockMvc.perform(get("/store/product/detail/2")).andDo(print()).andExpect(status().isOk()).andExpect(
                content().string(containsString("test-2"))
        );
    }
}
