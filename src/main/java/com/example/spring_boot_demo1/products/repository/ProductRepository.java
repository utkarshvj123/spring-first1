package com.example.spring_boot_demo1.products.repository;
import com.example.spring_boot_demo1.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Find product by its name
    Optional<Product> findByName(String name);

    // Find all products by category
    List<Product> findByCategory(String category);

    // Find all products by brand
    List<Product> findByBrand(String brand);

    // Find products by price range (e.g., between 100 and 500)
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Find products that are in stock (inStock == true)
    List<Product> findByInStockTrue();

    // Find products by discount (e.g., products with discount greater than 10%)
    List<Product> findByDiscountGreaterThan(double discount);

    // Find products by rating (e.g., products with rating greater than 4)
    List<Product> findByRatingsGreaterThanEqual(double rating);

    // Find products by supplier
    List<Product> findBySupplier(String supplier);

    // Find products by featured flag
    List<Product> findByFeaturedTrue();

    // Find products by type (e.g., Electronics, Furniture)
    List<Product> findByType(String type);

    // Custom query to find products with a specific name and category
    List<Product> findByNameAndCategory(String name, String category);

    // Check if a product exists by its SKU
//    Optional<Product> findBySku(String sku);
}
