package com.dreamshopbackend.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String product_name;
    private String product_category;
    private String product_brand;
    private BigDecimal price;
    private BigDecimal discount;
    private int inventory;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @OneToMany(mappedBy = "product", orphanRemoval = true)
//    private List<Image> images;
}
