package com.dreamshopbackend.demo.dto;

import com.dreamshopbackend.demo.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    public class CategoryDto {
        private Long category_id;
        private String category_name;
        private List<Product>products;

}
