package com.dreamshopbackend.demo.service;

import com.dreamshopbackend.demo.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    public ProductDto addProduct(ProductDto productDto);
    public void updateProduct(ProductDto productDto);
    public void deleteProduct(Long id);
    public ProductDto getProduct(Long id);
    public Iterable<ProductDto> getAllProducts();
    public List<ProductDto> findByCategory(Long categoryId);
    public List<ProductDto> findByCategoryAndName(Long categoryId, String name);
    public List<ProductDto> getProductsByCategoryName(String categoryName);
   
    public List<ProductDto> getProductsByCategoryNameAndName(String categoryName, String name);
    public List<ProductDto> findByBrand(String brand);
    public List<ProductDto> findByBrandAndName(String brand, String name);
    public List<ProductDto> getProductsByBrandName(String brandName);

    public List<ProductDto> getProductsByBrandNameAndName(String brandName, String name);
}

