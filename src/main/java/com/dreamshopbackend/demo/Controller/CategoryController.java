package com.dreamshopbackend.demo.Controller;

import com.dreamshopbackend.demo.dto.CategoryDto;
import com.dreamshopbackend.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product/category")

@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDto>addCategory(@RequestBody CategoryDto categoryDto )
    {
        CategoryDto savedCategory=categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>>getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
