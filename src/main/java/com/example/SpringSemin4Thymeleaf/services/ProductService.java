package com.example.SpringSemin4Thymeleaf.services;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * сервис обработки данных по Product
 */
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

    /**
     * выборка всех продуктов
     * @return
     */
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /**
     * Добавление продукта
     * @param product продукт
     * @return
     */
    public Product save(Product product){
        productRepository.save(product);
        return product;
    }

    /**
     * Удаление продукта
     * @param id идентификационный номер
     */
    public void deleteById(int id){
        productRepository.deleteById(id);
    }

    /**
     * выборка по ID
     * @param id
     * @return Product
     */
    public Product findById(int id){
        Product product = productRepository.findById(id);
        return product;
    }

    /**
     * Изменение продукта
     * @param product
     * @return Product
     */
    public Product update(Product product){
        productRepository.update(product);
        return product;
    }
}
