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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceSaveTest {
    /**
     * заклушка mock для репозитория
     */
    @Mock
    public ProductRepository productRepository;

    @InjectMocks
    public ProductService productService;

    @Test
    public void saveProductTest(){
        // pre
        Product product = new Product();
        product.setId(5);
        product.setName("Молоко");
        product.setDescription("для лошадей");
        product.setCount_prod(6);

        given(productRepository.findById(product.getId())).willReturn(product);
        //given(productRepository.save(product)).willReturn(product);

        // action
        productService.save(product);

        // check
        //Product actualProduct = productRepository
        verify(productRepository).save(product);
        //assertEquals(product,actualProduct);
    }
}
