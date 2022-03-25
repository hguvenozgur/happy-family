package com.java.happyfamily.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.model.purchase.Item;
import com.java.happyfamily.service.purchase.PurchaseService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseControllerTests {

    @MockBean
    PurchaseService purchaseService;

    @Autowired
    private MockMvc mockMvc;

    private static ProductDetail mockProductDetail;
    private static Item mockItem;

    @Test
    public void contextLoads() throws Exception {
        assertThat(purchaseService).isNotNull();
    }

    @BeforeAll
    public static void setup() {
        mockProductDetail = new ProductDetail();
        mockProductDetail.setQuantity(10);
        mockProductDetail.setBrand("test");
        mockProductDetail.setId(1);
        mockProductDetail.setType("test");

        mockItem = new Item();
        mockItem.setQuantity(1);
        mockItem.setProduct(new Product(1, "test"));
    }

    @Test
    public void buyShouldReturnSuccess() throws Exception {
        when(purchaseService.buyProduct(mockItem)).thenReturn(mockProductDetail);
        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(mockItem);

        this.mockMvc.perform(post("/purchase/buy").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON).content(requestJson)).
                andDo(print()).andExpect(status().isOk()
        );
    }

}
