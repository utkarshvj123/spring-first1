package com.example.spring_boot_demo1.products.controller;
import com.example.spring_boot_demo1.products.dto.ProductDTO;
import com.example.spring_boot_demo1.products.entity.Product;
import com.example.spring_boot_demo1.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create or Update Product
    @PostMapping
    public ProductDTO createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Get all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by id
    @GetMapping("/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id); // ensure the id matches for update
        return productService.saveProduct(product);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
