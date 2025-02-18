package com.dreamshopbackend.demo.mapper;
import com.dreamshopbackend.demo.dto.CategoryDto;
import com.dreamshopbackend.demo.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
       public static CategoryDto mapToCategoryDto(Category category){
                return new CategoryDto(
                   category.getCategory_id(),
                   category.getCategory_name(),
                        category.getProducts()
                   );
       }
       public static Category mapToCategory(CategoryDto categoryDto){
           Category category = new Category();
           category.setCategory_id(categoryDto.getCategory_id());
           category.setCategory_name(categoryDto.getCategory_name());
           return category;
       }
}
