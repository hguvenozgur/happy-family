package com.java.happyfamily.service.purchase.impl;

import com.java.happyfamily.model.orms.Purchase;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.model.purchase.Item;
import com.java.happyfamily.persistence.PurchaseRepository;
import com.java.happyfamily.service.product.ProductService;
import com.java.happyfamily.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductService productService;

    @Override
    public ProductDetail buyProduct(Item item) throws Exception{
        ProductDetail productDetail = productService.getProductDetail(item.getProduct().getId());

        if(productDetail.getQuantity() > 0 && productDetail.getQuantity() >= item.getQuantity()){

            Purchase purchase = new Purchase(productDetail.getId(), "test", item.getQuantity(), null, null);

            purchaseRepository.save(purchase);

            return productService.sellProduct(item.getProduct().getId(), item.getQuantity());
        }else{
            throw new Exception("Not enough number of quantity!");
        }
    }
}
