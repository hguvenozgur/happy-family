package com.happy.controller;

import com.happy.exception.PositiveIntegerException;
import com.happy.model.EggsQtyResult;
import com.happy.model.ErrorRestResult;
import com.happy.model.HusbandShopResult;
import com.happy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/husband")
public class HusbandController {
    private ProductService productService;

    @Autowired
    public HusbandController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public HusbandShopResult shop() {
        HusbandShopResult result;
        int eggsQuantity = productService.getEggsQty();
        int milkQuantity = productService.getMilkQty();

        if(eggsQuantity > 0 && milkQuantity >= 12){
            result = new HusbandShopResult(1, 12);
        }else if(milkQuantity > 0){
            result = new HusbandShopResult(1, 0);
        }else {
            result = new HusbandShopResult(0, 0);
        }

        return result;
    }



}
