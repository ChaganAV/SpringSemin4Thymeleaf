package com.example.SpringSemin4Thymeleaf.services;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * внедрим зависимость от репозитория
     * @param productRepository
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
