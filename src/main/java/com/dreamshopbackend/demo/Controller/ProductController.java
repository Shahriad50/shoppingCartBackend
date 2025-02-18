package com.dreamshopbackend.demo.Controller;

import com.dreamshopbackend.demo.dto.ProductDto;
import com.dreamshopbackend.demo.entity.Product;
import com.dreamshopbackend.demo.mapper.ProductMapper;
import com.dreamshopbackend.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping("/addproduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        ProductDto savedproduct= service.addProduct(productDto);

        return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
    }
    @GetMapping("/allproducts")
    public ResponseEntity<Iterable<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

}
