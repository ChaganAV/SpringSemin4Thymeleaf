package com.example.SpringSemin4Thymeleaf.controllers;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    /**
     * внедрим сервис продуктов
     * @param productService
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/products")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
}
