package com.java.happyfamily.service.purchase;

import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.model.purchase.Item;

public interface PurchaseService {

    ProductDetail buyProduct(Item item) throws Exception;
}
