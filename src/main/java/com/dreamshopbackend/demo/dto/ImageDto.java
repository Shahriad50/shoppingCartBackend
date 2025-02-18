package com.dreamshopbackend.demo.dto;

import com.dreamshopbackend.demo.entity.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class ImageDto {
    private Long image_id;
    List<String> downloadUrl;

    private Product product;
}
