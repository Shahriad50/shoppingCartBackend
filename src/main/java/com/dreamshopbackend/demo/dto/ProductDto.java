package com.dreamshopbackend.demo.dto;

import com.dreamshopbackend.demo.entity.Category;
import com.dreamshopbackend.demo.entity.Image;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long product_id;
    private String product_name;
    private String product_category;
    private String product_brand;
    private BigDecimal price;
    private BigDecimal discount;
    private int inventory;
    private String description;

    private Long category_id; // Reference to Category
//    private List<String> image_urls; // List of image URLs
}
