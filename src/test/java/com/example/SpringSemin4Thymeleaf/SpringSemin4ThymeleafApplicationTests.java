package com.example.SpringSemin4Thymeleaf;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.repositories.ProductRepository;
import com.example.SpringSemin4Thymeleaf.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringSemin4ThymeleafApplicationTests {

	@MockBean
	public ProductRepository productRepository;

	@Autowired
	public ProductService productService;


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
