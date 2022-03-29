package com.happy.service.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.happy.controller.HusbandController;
import com.happy.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HusbandController.class)
public class HusbandControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @BeforeAll
    public static void setup(){

    }

    @Test
    public void contextLoads() {
        assertThat(productService).isNotNull();
    }

    @Test
    public void shopShouldReturnTwelveMilkZeroEgg() throws Exception{
        when(productService.getEggsQty()).thenReturn(10);
        when(productService.getMilkQty()).thenReturn(20);

        this.mockMvc.perform(post("/v1/husband/shop")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.milk").value(1)).
                andExpect(MockMvcResultMatchers.jsonPath("$.eggs").value(12));
    }

    @Test
    public void shopShouldReturnOneMilkZeroEgg() throws Exception{
        when(productService.getEggsQty()).thenReturn(0);
        when(productService.getMilkQty()).thenReturn(20);

        this.mockMvc.perform(post("/v1/husband/shop")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.milk").value(1)).
                andExpect(MockMvcResultMatchers.jsonPath("$.eggs").value(0));
    }

    @Test
    public void shopShouldReturnZeroMilkZeroEgg() throws Exception{
        when(productService.getEggsQty()).thenReturn(0);
        when(productService.getMilkQty()).thenReturn(0);

        this.mockMvc.perform(post("/v1/husband/shop")).andExpect(status().isOk()).andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$.milk").value(0)).
                andExpect(MockMvcResultMatchers.jsonPath("$.eggs").value(0));
    }

}
