package com.dreamshopbackend.demo.dto;

import com.dreamshopbackend.demo.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    public class CategoryDto {
        private Long category_id;
        private String category_name;
        private List<Product>products;

}
