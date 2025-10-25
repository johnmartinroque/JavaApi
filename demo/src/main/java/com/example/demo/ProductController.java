package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1, "Laptop", 59999.99),
                new Product(2, "Smartphone", 29999.50),
                new Product(3, "Headphones", 3999.00)
        );
    }
}
