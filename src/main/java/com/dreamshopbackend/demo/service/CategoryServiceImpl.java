package com.dreamshopbackend.demo.service;

import com.dreamshopbackend.demo.dto.CategoryDto;
import com.dreamshopbackend.demo.entity.Category;
import com.dreamshopbackend.demo.mapper.CategoryMapper;
import com.dreamshopbackend.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.dreamshopbackend.demo.mapper.CategoryMapper.mapToCategoryDto;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository ;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.mapToCategory(categoryDto);
        Category savedCategory=categoryRepository.saveAndFlush(category);

        return mapToCategoryDto(savedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toCollection(this::getAllCategories));
    }

    @Override
    public CategoryDto getCategory(Long id) {
        return null;
    }
}
