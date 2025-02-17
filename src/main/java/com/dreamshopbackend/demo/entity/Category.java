package com.dreamshopbackend.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;
    private String category_name;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    List<Product> products;
}
