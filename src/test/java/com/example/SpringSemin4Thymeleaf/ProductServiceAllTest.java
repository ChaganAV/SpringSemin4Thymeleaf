package com.example.SpringSemin4Thymeleaf;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.repositories.ProductRepository;
import com.example.SpringSemin4Thymeleaf.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceAllTest {
    // заглушка
    @Mock
    private ProductRepository productRepository;

    // внедрим сервис
    @InjectMocks
    private ProductService productService;
    @Test
    public void ProductServiceAll(){
        // pre
        Product product = new Product();
        product.setId(5);
        product.setName("Молоко");
        product.setDescription("для лошадей");
        product.setCount_prod(6);

        List<Product> expectedProducts = Collections.singletonList(product);
        when(productRepository.findAll()).thenReturn(expectedProducts);

        // action
        List<Product> actualProducts = productService.findAll();

        // check
        assertEquals(expectedProducts,actualProducts);
    }
}
