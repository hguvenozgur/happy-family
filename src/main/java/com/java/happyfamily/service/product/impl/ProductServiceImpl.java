package com.java.happyfamily.service.product.impl;

import com.java.happyfamily.model.product.Product;
import com.java.happyfamily.model.product.ProductDetail;
import com.java.happyfamily.persistence.ProductRepository;
import com.java.happyfamily.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() throws Exception{

        List<com.java.happyfamily.model.orms.Product> products = productRepository.findAll();
        if(products.size() == 0){
            throw new Exception("Products are not available!");
        }
        List<Product> productList;
        productList = products.stream().map(i -> new Product(i.getId(), i.getName())).collect(Collectors.toList());
        return productList;
    }

    @Override
    public ProductDetail getProductDetail(Integer id) throws Exception{
        Optional optionalProduct;
        optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            com.java.happyfamily.model.orms.Product product = (com.java.happyfamily.model.orms.Product) optionalProduct.get();

            ProductDetail productDetail = new ProductDetail();
            productDetail.setId(product.getId());
            productDetail.setPrice(product.getPrice());
            productDetail.setQuantity(product.getQuantity());
            productDetail.setBrand(product.getBrand());

            return productDetail;
        }

        throw new Exception("Details of selected product is not available!");
    }

    @Override
    public ProductDetail sellProduct(Integer productId, int quantity) throws Exception{
        com.java.happyfamily.model.orms.Product product = productRepository.getById(productId);
        product.setQuantity(product.getQuantity()-quantity);
        if(product.getQuantity() > 0){
            productRepository.save(product);



            ProductDetail productDetail = new ProductDetail();
            productDetail.setId(product.getId());
            productDetail.setBrand(product.getBrand());
            productDetail.setQuantity(product.getQuantity());
            productDetail.setPrice(product.getPrice());
            return productDetail;
        }

        throw new Exception("Not enough number of product");
    }
}
