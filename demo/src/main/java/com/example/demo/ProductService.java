package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    private final Map<Integer, Product> products = new HashMap<>();
    private int currentId = 1;

    public ProductService() {
        // Add some sample products
        addProduct(new Product(0, "Laptop", 59999.99));
        addProduct(new Product(0, "Smartphone", 29999.50));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public Product addProduct(Product product) {
        product.setId(currentId++);
        products.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        if (products.containsKey(id)) {
            updatedProduct.setId(id);
            products.put(id, updatedProduct);
            return updatedProduct;
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        return products.remove(id) != null;
    }
}
