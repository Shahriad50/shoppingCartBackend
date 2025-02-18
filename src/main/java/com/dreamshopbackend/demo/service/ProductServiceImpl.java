package com.dreamshopbackend.demo.service;

import com.dreamshopbackend.demo.dto.ProductDto;
import com.dreamshopbackend.demo.entity.Image;
import com.dreamshopbackend.demo.entity.Product;
import com.dreamshopbackend.demo.mapper.ProductMapper;
import com.dreamshopbackend.demo.repository.CategoryRepository;
import com.dreamshopbackend.demo.repository.ImageRepository;
import com.dreamshopbackend.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository ImageRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductDto addProduct(ProductDto productDto){
        Product product = productMapper.mapToProduct(productDto);
        // Set category
        product.setCategory(categoryRepository.findById(productDto.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found")));

        // Set images
//        List<Image> images = productDto.getImage_urls()
//                .stream()
//                .map(url -> new Image(url, product))
//                .collect(Collectors.toList());
//        product.setImages(images);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }
    @Override
    public void updateProduct(ProductDto productDto){
        return;
    }
    @Override
    public void deleteProduct(Long id){
        return;
    }

    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        // Conversion of Product to ProductDto should be implemented in a mapper method
        return productMapper.mapToProductDto(product);
    }

    @Override
    public Iterable<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            // Conversion of Product to ProductDto should be implemented in a mapper method
            productDtos.add(productMapper.mapToProductDto(product));
        }
        return productDtos;
    }

    @Override
    public List<ProductDto> findByCategory(Long categoryId) {
        List<Product> products = productRepository.findAllByCategory(categoryId);
        return products.stream().map(productMapper::mapToProductDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ProductDto> findByCategoryAndName(Long categoryId, String name) {
        List<Product> products = productRepository.findByCategoryAndName(categoryId, name);
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategoryNameAndName(String categoryName, String name) {
        return null;
    }

    @Override
    public List<ProductDto> findByBrand(String brand) {
        return null;
    }

    @Override
    public List<ProductDto> findByBrandAndName(String brand, String name) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByBrandName(String brandName) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByBrandNameAndName(String brandName, String name) {
        return null;
    }

}
