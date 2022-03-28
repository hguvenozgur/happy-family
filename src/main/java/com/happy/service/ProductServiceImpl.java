package com.happy.service;

import com.happy.exception.PositiveIntegerException;
import com.happy.model.Product;
import com.happy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public int getMilkQty() {
        Optional<Product> prod = productRepository.findById(1);
        Product product = prod.get();
        return product.getMilkQty();
    }

    @Override
    public int getEggsQty() {
        Optional<Product> prod = productRepository.findById(1);
        Product product = prod.get();
        return product.getEggQty();
    }

    @Override
    public int buyMilk(int qty) throws PositiveIntegerException {
        if (qty <= 0)
            throw new PositiveIntegerException();

        Optional<Product> prod = productRepository.findById(1);
        Product product = prod.get();
        int curMilkQty = product.getMilkQty();
        int purchasedQty = Math.min(qty, curMilkQty);

        // update
        product.setMilkQty(curMilkQty - purchasedQty);
        productRepository.save(product);

        return purchasedQty;
    }

    @Override
    public int buyEggs(int qty) throws PositiveIntegerException {
        if (qty <= 0)
            throw new PositiveIntegerException();

        Optional<Product> prod = productRepository.findById(1);
        Product product = prod.get();
        int curEggQty = product.getEggQty();
        int purchasedQty = Math.min(qty, curEggQty);

        // update
        product.setEggQty(curEggQty - purchasedQty);
        productRepository.save(product);

        return purchasedQty;
    }
}
