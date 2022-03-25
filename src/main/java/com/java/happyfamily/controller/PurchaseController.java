package com.java.happyfamily.controller;

import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.model.purchase.Item;
import com.java.happyfamily.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;


    @PostMapping("/buy")
    public ProductDetail buyProduct(@RequestBody Item item) throws Exception{
        return purchaseService.buyProduct(item);
    }
}
