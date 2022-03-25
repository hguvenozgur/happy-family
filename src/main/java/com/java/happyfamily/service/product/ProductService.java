package com.java.happyfamily.service.product;

import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws Exception;

    ProductDetail getProductDetail(Integer id) throws Exception;

    ProductDetail sellProduct(Integer productId, int quantity)  throws Exception;
}
