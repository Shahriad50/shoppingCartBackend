package com.dreamshopbackend.demo.mapper;
import com.dreamshopbackend.demo.dto.CategoryDto;
import com.dreamshopbackend.demo.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
        CategoryDto maptoCategoryDto(Category category);

        Category mapToCategory(CategoryDto dto);
}
