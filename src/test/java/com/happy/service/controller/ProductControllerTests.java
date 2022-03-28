package com.happy.service.controller;

import com.happy.controller.ProductController;
import com.happy.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setup(){

    }

    @Test
    public void contextLoads(){
        assertThat(productService).isNotNull();
    }

    @Test
    public void hasMilkShouldReturnNumberOfMilks() throws Exception{
        when(productService.getMilkQty()).thenReturn(1000);

        this.mockMvc.perform(get("/v1/store/hasmilk")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.milk").value(1000));

    }

    @Test
    public void hasEggsShouldReturnNumberOfEggs() throws Exception{
        when(productService.getEggsQty()).thenReturn(1000);

        this.mockMvc.perform(get("/v1/store/haseggs")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.eggs").value(1000));
    }

    @Test
    public void buyMilkShouldReturnSuccess() throws Exception{
        when(productService.buyMilk(1)).thenReturn(1);
        this.mockMvc.perform(post("/v1/store/buymilk?quantity=1")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.milk").value(1));

    }

    @Test
    public void buyEggsShouldReturnSuccess() throws Exception{
        when(productService.buyEggs(1)).thenReturn(1);
        this.mockMvc.perform(post("/v1/store/buyeggs?quantity=1")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.eggs").value(1));

    }
}
