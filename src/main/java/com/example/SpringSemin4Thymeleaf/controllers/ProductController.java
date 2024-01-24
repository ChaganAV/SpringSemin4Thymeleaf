package com.example.SpringSemin4Thymeleaf.controllers;

import com.example.SpringSemin4Thymeleaf.model.Product;
import com.example.SpringSemin4Thymeleaf.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Вывод на главное представление
     * @return страница домашней страницы
     */
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    /**
     * вывод списка продуктов
     * @param model передаем продукт в представление
     * @return представление списка продуктов
     */
    @GetMapping("/products")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    /**
     * Добавление продукта
     * @param product
     * @return
     */
    @GetMapping("/product-create")
    public String createProductForm(Product product){
        return "product-create";
    }

    /**
     * Добавление продукта
     * @param product
     * @return переопределяем на представление списка продуктов
     */
    @PostMapping("/product-create")
    public String createProduct(Product product){
        productService.save(product);
        return "redirect:/products";
    }

    /**
     * Удаление прдукта по ID
     * @param id
     * @return переопределяем на представление списка продуктов
     */
    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteById(id);
        return "redirect:/products";
    }

    /**
     * Изменение продукта
     * @param id ID
     * @param model модель для представления
     * @return переходим на форму заполнения данными
     */
    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    /**
     * Метод post, получает Модель продукта для изменения в базе
     * @param product продукт
     * @return переопределяем на представление со списком продуктов
     */
    @PostMapping("/product-update")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.update(product);
        return "redirect:/products";
    }
}
