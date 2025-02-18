package com.dreamshopbackend.demo.repository;
import com.dreamshopbackend.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.product_name = :name")
    Product findByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.price = :price")
    Product findByPrice(@Param("price") Double price);

    @Query("SELECT p FROM Product p WHERE p.category.category_id = :categoryId")
    List<Product> findAllByCategory(@Param("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.category.category_id = :categoryId AND p.product_name = :name")
    List<Product> findByCategoryAndName(@Param("categoryId") Long categoryId, @Param("name") String name);

}
