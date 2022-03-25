package com.java.happyfamily.controller;

import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts() throws Exception{
        List products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/product/detail/{id}")
    public ProductDetail productDetail(@PathVariable Integer id) throws Exception{
        return productService.getProductDetail(id);
    }

}
