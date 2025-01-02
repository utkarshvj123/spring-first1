package com.example.spring_boot_demo1.products.service;

import com.example.spring_boot_demo1.products.dto.ProductDTO;
import com.example.spring_boot_demo1.products.entity.Product;
import com.example.spring_boot_demo1.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Convert entity to DTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setType(product.getType());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setPhoto(product.getPhoto());
        dto.setCategory(product.getCategory());
        dto.setBrand(product.getBrand());
        dto.setDescription(product.getDescription());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setDiscount(product.getDiscount());
        dto.setRatings(product.getRatings());
        dto.setSupplier(product.getSupplier());
        dto.setFeatured(product.isFeatured());
        dto.setColor(product.getColor());
        dto.setSize(product.getSize());
        dto.setLocation(product.getLocation());
        dto.setInStock(product.isInStock());
        return dto;
    }

    // Create or Update Product
    public ProductDTO saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    // Get all products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get product by id
    public Optional<ProductDTO> getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::convertToDTO);
    }

    // Delete product by id
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
